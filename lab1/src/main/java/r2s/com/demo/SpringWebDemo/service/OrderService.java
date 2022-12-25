package r2s.com.demo.SpringWebDemo.service;


import r2s.com.demo.SpringWebDemo.dto.request.CreateOrderRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    public List<CreateOrderRequestDTO> getListOrder(){
        List<CreateOrderRequestDTO> orderList= new ArrayList<>();
        CreateOrderRequestDTO order1= new CreateOrderRequestDTO(1,200000,new Date(2022,1,1),true,1);
        CreateOrderRequestDTO order2= new CreateOrderRequestDTO(2,200000,new Date(2022,1,1),true,1);
        orderList.add(order1);
        orderList.add(order2);
        return orderList;
    }
}
