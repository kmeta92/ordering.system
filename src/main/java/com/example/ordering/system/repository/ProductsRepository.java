package com.example.ordering.system.repository;

import com.example.ordering.system.model.Order;
import com.example.ordering.system.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {

    @Query("Select p.* FROM Product p")
    Optional<List<Product>> getProductsList(@Param("Id")Integer Id);

    @Query("Select p.category FROM Product p")
    Optional<List<Product>> getCategoriesList(@Param("Id")Integer Id);

    @Query("UPDATE Product SET isDeleted = true WHERE id = :id")
    void deactivateProduct(@Param("id") Integer id);
}
