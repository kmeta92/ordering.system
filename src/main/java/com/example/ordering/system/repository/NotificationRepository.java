package com.example.ordering.system.repository;

import com.example.ordering.system.model.Notification;
import com.example.ordering.system.model.Order;
import com.example.ordering.system.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

    @Query("INSERT into Notification (id, message) values (id, message) WHERE id = :id")
    default void insertMessage(@Param("id") Integer id) {

    }
}
