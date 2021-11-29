import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private final InetAddress host;
	private int port;
	
	public Client(InetAddress host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	
	private void execute() throws IOException {
		Socket client = new Socket(host, port);
		ReadClient read = new ReadClient(client);
		read.start(); // Khởi chạy thread
		WriteClient write = new WriteClient(client);
		write.start(); // Khởi chạy song song với luồng Đọc.
	}
	
	public static void main(String[] args) throws IOException {
		Client client = new Client(InetAddress.getByName("192.168.50.78"), 9898);
		client.execute();
	}
}

class ReadClient extends Thread {
	private Socket client;

	public ReadClient(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		//Đọc dữ liệu
		DataInputStream input = null;
		try {
			input = new DataInputStream(client.getInputStream());
			while(true) {
				String sms = input.readUTF();
				System.out.println(sms);
			}
		} catch (Exception e) {
			try {
				input.close();
				client.close();
			} catch (IOException ex) {
				System.out.println("Ngắt kết nối Server");
			}
		}
	}
}

class WriteClient extends Thread {
	private Socket client;
	
	public WriteClient(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		DataOutputStream output = null;
		Scanner sc = null;
		try {
			output = new DataOutputStream(client.getOutputStream());
			sc = new Scanner(System.in);
			while (true) {
				String sms = sc.nextLine();
				while (true ){
				output.writeUTF(sms);} // Bắt đầu gửi lên Server
			}
		} catch (Exception e) {
			try {
				output.close();
				client.close();
			} catch (IOException ex) {
				System.out.println("Ngắt kết nối Server");
			}
		}
	}
}