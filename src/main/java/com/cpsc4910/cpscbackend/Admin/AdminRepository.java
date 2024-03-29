package com.cpsc4910.cpscbackend.Admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long>{
    public Admin findByEmail(String email);
}
