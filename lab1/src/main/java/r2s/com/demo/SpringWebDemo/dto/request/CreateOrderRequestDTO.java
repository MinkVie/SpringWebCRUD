package r2s.com.demo.SpringWebDemo.dto.request;

import java.util.Date;

public class CreateOrderRequestDTO {
    private int id;
    private long totalPay;
    private Date orderDate;
    private boolean status;
    private int cartId;

    public CreateOrderRequestDTO(int id, long totalPay, Date orderDate, boolean status, int cartId) {
        this.id = id;
        this.totalPay = totalPay;
        this.orderDate = orderDate;
        this.status = status;
        this.cartId = cartId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(long totalPay) {
        this.totalPay = totalPay;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
