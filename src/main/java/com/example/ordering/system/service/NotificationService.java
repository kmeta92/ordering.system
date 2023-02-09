package com.example.ordering.system.service;

import com.example.ordering.system.model.Client;
import com.example.ordering.system.model.Notification;
import com.example.ordering.system.model.Order;
import com.example.ordering.system.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public String receiveMessage(Notification notification){
        return notification.getMessage();
    }

    public void sendEmail(Order order, String message){
        order.placeMessage(message);
    }

    public void sendSMS(Order order, Client client){
        order.placeMessage("Order Id: " + order.getId() + " Total price: " + order.getPrice());
    }
}
