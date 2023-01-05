package r2s.com.demo.SpringWebDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import r2s.com.demo.SpringWebDemo.entity.Address;
import r2s.com.demo.SpringWebDemo.entity.Cart;
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
