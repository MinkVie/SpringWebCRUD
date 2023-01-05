package r2s.com.demo.SpringWebDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private long price;

    @Column(name = "SALER_NAME")
    private String salerName;

    @Column(name = "IS_DELETED")
    private boolean isDeleted;

    @Column(name = "CATEGORY_ID")
    private int categoryId;
}
