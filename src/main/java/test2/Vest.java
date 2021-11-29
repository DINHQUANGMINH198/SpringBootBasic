package test2;

import org.springframework.stereotype.Component;

@Component("vest")
public class Vest implements Outfit{
    @Override
    public void wear() {
        System.out.println("Đang  mặc vest");

    }
}
