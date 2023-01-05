package r2s.com.demo.SpringWebDemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertUserRequestDTO {

    private String username;

    private String name;

    private String password;

    private String phone;

    private String gender;

    private String email;

    private Date birthday;
}
