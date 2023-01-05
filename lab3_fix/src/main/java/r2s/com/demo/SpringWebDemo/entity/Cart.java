package r2s.com.demo.SpringWebDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "CART")
public class Cart {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USERS_ID")
    private int userId;

}
