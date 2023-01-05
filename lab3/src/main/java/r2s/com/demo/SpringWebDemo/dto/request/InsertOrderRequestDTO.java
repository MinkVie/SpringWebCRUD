package r2s.com.demo.SpringWebDemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertOrderRequestDTO {

    private long totalPay;

    private Date orderDate;

    private boolean status;

    private int cartId;
}
