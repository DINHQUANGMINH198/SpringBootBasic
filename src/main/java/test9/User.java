package test9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userlogin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // Mapping thông tin biến với tên cột trong Database
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    // Nếu không đánh dấu @Column thì sẽ mapping tự động theo tên biến


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
