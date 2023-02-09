package com.example.ordering.system.service;

import com.example.ordering.system.model.Order;
import com.example.ordering.system.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrUpdate(Order order){
        order.setClient(order.getClient());
        order.setProduct(order.getProduct());
        String message = "A new order has been placed";
        order.placeMessage(message);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByClientId(Integer clientid){
        List<Order> orderList = new ArrayList<>();
        Optional<List<Order>> result = orderRepository.getOrdersByClientId(clientid);
        if(result.isPresent()){
            orderList.addAll(result.get());
        }
        return  orderList;
    }

    public Order getOrderById(Integer orderId){
        Order order = null;
        Optional<Order> result = orderRepository.findById(orderId);
        if(result.isPresent()){
            order = result.get();
        }
        return order;
    }
}
