package com.example.ordering.system.repository;

import com.example.ordering.system.model.User;
import com.example.ordering.system.model.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticationRepository extends CrudRepository<User, Integer> {

    @Query("SELECT c FROM User c")
    List<User> getByUserType(@Param("userType") UserType userType);

    @Query(value = "SELECT c.* FROM users c where c.user_type=:userType", nativeQuery = true)
    List<User> getByUserTypeNativeQuery(@Param("userType") UserType userType);

    @Query("UPDATE User SET isDeleted = true WHERE id = :id")
    void deactivateUser(@Param("id") Integer id);

}
