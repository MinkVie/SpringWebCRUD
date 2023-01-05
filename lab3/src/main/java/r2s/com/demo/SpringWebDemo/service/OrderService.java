package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.InsertOrderRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrderDatabase();

    Order insertOrder(InsertOrderRequestDTO requestDTO);
}
