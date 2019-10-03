package com.cpsc4910.cpscbackend.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<DriverOrder, Integer> {
}
