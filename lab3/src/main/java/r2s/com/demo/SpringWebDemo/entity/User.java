package r2s.com.demo.SpringWebDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity(name = "USER_INFO")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "BIRTHDAY")
    private Date birthday;

}
