package r2s.com.demo.SpringWebDemo.dto.request;

import java.io.Serializable;

public class CreateCategoryRequestDTO implements Serializable {
        private int id;
        private String name;

        public CreateCategoryRequestDTO() {
        }

    public CreateCategoryRequestDTO(int id, String name) {
        this.id = id;
        this.name = name;
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

}
