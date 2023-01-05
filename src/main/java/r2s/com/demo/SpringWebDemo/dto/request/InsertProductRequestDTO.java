package r2s.com.demo.SpringWebDemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertProductRequestDTO {

    private String name;

    private long price;

    private String salerName;

    private boolean isDeleted;

    private int categoryId;
}
