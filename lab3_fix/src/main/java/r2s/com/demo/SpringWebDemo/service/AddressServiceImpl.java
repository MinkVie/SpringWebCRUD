package r2s.com.demo.SpringWebDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import r2s.com.demo.SpringWebDemo.dto.request.InsertAddressRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Address;
import r2s.com.demo.SpringWebDemo.repository.AddressRepository;

import java.util.List;
@Component
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddressDatabase() {
        Iterable<Address> addressIterable = addressRepository.findAll();
        return (List<Address>) addressIterable;
    }


    @Override
    public Address insertAddress(InsertAddressRequestDTO requestDTO) {
        Address address= new Address();
        address.setUserId(requestDTO.getUserId());
        address.setName(requestDTO.getName());
        address.setDefaultAddress(requestDTO.isDefaultAddress());
        address.setDeleted(requestDTO.isDeleted());
        address.setDistrict(requestDTO.getDistrict());
        address.setPhone(requestDTO.getPhone());
        address.setProvince(requestDTO.getProvince());
        address.setStreet(requestDTO.getStreet());
        address.setType(requestDTO.isType());
        addressRepository.save(address);
        return address;
    }
}
