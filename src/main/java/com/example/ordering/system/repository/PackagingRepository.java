package com.example.ordering.system.repository;

import com.example.ordering.system.model.Order;
import com.example.ordering.system.model.OrderStatus;
import com.example.ordering.system.model.User;
import com.example.ordering.system.model.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PackagingRepository extends CrudRepository<Order, Integer> {

    @Query("SELECT o FROM Order o")
    List<Order> getByOrderStatus(@Param("orderStatus") OrderStatus orderStatus);

    @Query(value = "SELECT o.* FROM orders o where o.order_status=:orderStatus", nativeQuery = true)
    List<Order> getByOrderStatusNativeQuery(@Param("orderStatus") OrderStatus orderStatus);

    @Query("UPDATE Order SET isDeleted = true WHERE id = :id")
    void deactivateOrder(@Param("id") Integer id);

    }
