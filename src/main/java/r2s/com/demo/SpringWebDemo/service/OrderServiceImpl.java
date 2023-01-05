package r2s.com.demo.SpringWebDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import r2s.com.demo.SpringWebDemo.dto.request.InsertOrderRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Order;
import r2s.com.demo.SpringWebDemo.repository.OrderRepository;

import java.util.List;
@Component
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrderDatabase() {
        Iterable<Order> orderIterable = orderRepository.findAll();
        return (List<Order>) orderIterable;
    }


    @Override
    public Order insertOrder(InsertOrderRequestDTO requestDTO) {
        Order order= new Order();
        order.setOrderDate(requestDTO.getOrderDate());
        order.setStatus(requestDTO.isStatus());
        order.setCartId(requestDTO.getCartId());
        order.setTotalPay(requestDTO.getTotalPay());
        orderRepository.save(order);
        return order;
    }
}
