
package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.CreateAddressRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdateAddressRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.AddressResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.PagingAddressListResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.PagingUserListResponseDTO;
import r2s.com.demo.SpringWebDemo.service.AddressService;
import r2s.com.demo.SpringWebDemo.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value = "/address")
public class AddressController {
    private AddressService addressService = new AddressService();

    @GetMapping
    public ResponseEntity<?> getAllAddress(@RequestParam(value = "page", required = false) Integer page,
                                           @RequestParam(value = "size", required = false) Integer size,
                                           @RequestParam(value = "sort", required = false) String sort) {
        List<AddressResponseDTO> addressList = addressService.getListAddress();
        PagingAddressListResponseDTO response = new PagingAddressListResponseDTO();
        response.setPage(page);
        response.setSize(size);
        response.setSort(sort);
        return ResponseEntity.ok(addressList);
    }

    @GetMapping("/{address-id}")
    public ResponseEntity getAddressByAddressId(@PathVariable(value = "address-id") int addressID) {
        List<AddressResponseDTO> responseDTOList = addressService.getListAddress()
                .stream()
                .filter(e-> e.getId() == addressID)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
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

    @PutMapping("/{address_id}")
    public ResponseEntity updateAddress (@PathVariable(value = "address_id") int addressID,
                                         @RequestBody UpdateAddressRequestDTO updateAddressRequestDTO) {
        AddressResponseDTO responseDTO = new AddressResponseDTO();
        responseDTO.setId(addressID);
        responseDTO.setName(updateAddressRequestDTO.getName());
        responseDTO.setPhone(updateAddressRequestDTO.getPhone());
        responseDTO.setProvince(updateAddressRequestDTO.getProvince());
        responseDTO.setDistrict(updateAddressRequestDTO.getDistrict());
        responseDTO.setStreet(updateAddressRequestDTO.getStreet());
        responseDTO.setDefaultAddress(updateAddressRequestDTO.isDefaultAddress());
        responseDTO.setType(updateAddressRequestDTO.isType());
        responseDTO.setUserId(updateAddressRequestDTO.getUserId());
        responseDTO.setDeleted(updateAddressRequestDTO.isDeleted());

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{address_id}")
    public ResponseEntity deleteAddress (@PathVariable(value = "address_id") int addressId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
