package r2s.com.demo.SpringWebDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import r2s.com.demo.SpringWebDemo.entity.Category;
import r2s.com.demo.SpringWebDemo.entity.User;

import java.util.Locale;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
