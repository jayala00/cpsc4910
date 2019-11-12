package com.cpsc4910.cpscbackend.Driver;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {
    public Driver findByEmail(String email);
}
