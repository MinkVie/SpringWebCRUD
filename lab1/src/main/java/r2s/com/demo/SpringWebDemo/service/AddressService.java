package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.CreateAddressRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class AddressService {
    public List<CreateAddressRequestDTO> getListAddress(){
        List<CreateAddressRequestDTO> addressList= new ArrayList<>();
        CreateAddressRequestDTO address1= new CreateAddressRequestDTO(1,"Nguyen Minh Vy 1","123456789","Longan","Kien Tuong","DT831",true, true, false,1);
        CreateAddressRequestDTO address2= new CreateAddressRequestDTO(1,"Nguyen Minh Vy 2","123456789","Longan","Kien Tuong","DT831",true, false, false,1);
        addressList.add(address1);
        addressList.add(address2);
        return addressList;
    }
}
