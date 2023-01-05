package r2s.com.demo.SpringWebDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import r2s.com.demo.SpringWebDemo.entity.Product;
import r2s.com.demo.SpringWebDemo.entity.User;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
