package com.javatechie.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.os.api.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
