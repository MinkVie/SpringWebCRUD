package r2s.com.demo.SpringWebDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "TOTAL_PAY")
    private long totalPay;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "STATUS")
    private boolean status;
    @Column(name = "CART_ID")
    private int cartId;
}
