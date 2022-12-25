
package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.CreateAddressRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;
import r2s.com.demo.SpringWebDemo.service.AddressService;
import r2s.com.demo.SpringWebDemo.service.ProductService;

import java.util.List;

@RestController()
@RequestMapping(value = "/address")
public class AddressController {
    private AddressService addressService = new AddressService();

    @GetMapping
    public ResponseEntity<?> getAllAddress() {
        List<CreateAddressRequestDTO> addressList = addressService.getListAddress();
        return ResponseEntity.ok(addressList);
    }

    @PostMapping
    public ResponseEntity insertAddress(@RequestBody CreateAddressRequestDTO createAddressRequestDTO) {
        int id = createAddressRequestDTO.getId();
        String name = createAddressRequestDTO.getName();
        String price = createAddressRequestDTO.getPhone();
        String salerName = createAddressRequestDTO.getProvince();
        String district = createAddressRequestDTO.getDistrict();
        String street = createAddressRequestDTO.getStreet();
        boolean type = createAddressRequestDTO.isType();
        boolean defaultAddress = createAddressRequestDTO.isDefaultAddress();
        boolean deleted = createAddressRequestDTO.isDeleted();
        int userId = createAddressRequestDTO.getUserId();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(id)
                .append(name)
                .append(price)
                .append(salerName)
                .append(district)
                .append(street)
                .append(type)
                .append(defaultAddress)
                .append(deleted)
                .append(userId)
                .toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
