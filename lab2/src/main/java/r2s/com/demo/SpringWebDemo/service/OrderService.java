package r2s.com.demo.SpringWebDemo.service;


import r2s.com.demo.SpringWebDemo.dto.request.CreateOrderRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.OrderResponseDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    public List<OrderResponseDTO> getListOrder(){
        List<OrderResponseDTO> orderList= new ArrayList<>();
        OrderResponseDTO order1= new OrderResponseDTO(1,200000,new Date(2022,1,1),true,1);
        OrderResponseDTO order2= new OrderResponseDTO(2,200000,new Date(2022,1,1),true,1);
        orderList.add(order1);
        orderList.add(order2);
        return orderList;
    }
}
