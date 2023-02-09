package com.example.ordering.system.service;

import com.example.ordering.system.model.Order;
import com.example.ordering.system.repository.PackagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PackagingService {

    private final PackagingRepository packagingRepository;

    @Autowired
    public PackagingService(PackagingRepository packagingRepository) {
        this.packagingRepository = packagingRepository;
    }

    public Order getOrder(Integer orderId) {

        Optional<Order> order = packagingRepository.findById(orderId);
        if(!order.isPresent()){
            throw new RuntimeException("Order not found!");
        }
        return order.get();
    }

    public void createOrUpdateOrder(Order order) {
        if (null == order.getId()) {
            createOrder(order);
            return;
        }
        updateOrder(order);
    }

    private void createOrder(Order order){
        packagingRepository.save(order);
    }

    private void updateOrder(Order order){
        packagingRepository.save(order);
    }

    private void deleteOrder(Integer orderId){
        packagingRepository.deactivateOrder(orderId);
    }

}
