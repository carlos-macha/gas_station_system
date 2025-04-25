package com.example.gas_station_system.repositories;

import com.example.gas_station_system.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;



public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "SELECT * FROM user WHERE id = :id", nativeQuery = true)
    User FindUserById(@Param("id") Long id);

    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    User FindUserByEmail(@Param("email") String email);
}




