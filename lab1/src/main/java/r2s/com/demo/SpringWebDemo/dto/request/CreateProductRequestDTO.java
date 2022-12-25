package r2s.com.demo.SpringWebDemo.dto.request;

public class CreateProductRequestDTO {
    private int id;
    private String name;
    private long price;
    private String salerName;
    private boolean isDeleted;
    private int categoryId;

    public CreateProductRequestDTO() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public CreateProductRequestDTO(int id, String name, long price, String salerName, boolean isDeleted, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.salerName = salerName;
        this.isDeleted = isDeleted;
        this.categoryId = categoryId;
    }
}
