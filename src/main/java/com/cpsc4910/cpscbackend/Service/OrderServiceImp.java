package com.cpsc4910.cpscbackend.Service;
import com.cpsc4910.cpscbackend.Order.DriverOrder;
import com.cpsc4910.cpscbackend.Order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String addOrder(long id, long orderNumber, String status) {
        DriverOrder o = new DriverOrder();
        o.setOrderid(id);
        o.setStatus(status);
        orderRepository.save(o);

        return "Order number: " + orderNumber + " has been submitted.";
    }

    public Iterable<DriverOrder> allOrders() {
        return orderRepository.findAll();
    }
}
