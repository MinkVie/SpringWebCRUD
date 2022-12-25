package r2s.com.demo.SpringWebDemo.dto.request;

public class CreateCartRequestDTO {
    private int id;
    private int userId;

    public CreateCartRequestDTO(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
