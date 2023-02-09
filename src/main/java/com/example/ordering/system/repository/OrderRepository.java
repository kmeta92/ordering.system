package com.example.ordering.system.repository;

import com.example.ordering.system.model.Order;
import com.example.ordering.system.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Integer> {


    @Query("Select o FROM Order o WHERE client.id = :clientId")
    Optional<List<Order>> getOrdersByClientId(@Param("clientId")Integer clientId);

}
