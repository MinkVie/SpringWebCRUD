package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.InsertAddressRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddressDatabase();

    Address insertAddress(InsertAddressRequestDTO requestDTO);
}
