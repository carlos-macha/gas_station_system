package com.example.gas_station_system.repositories;

import com.example.gas_station_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "SELECT * FROM user WHERE id = :id", nativeQuery = true)
    User FindUserById(@Param("id") Long id);

    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    User FindUserByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM user WHERE name = :name", nativeQuery = true)
    User FindUserByName(@Param("name") String name);
}




