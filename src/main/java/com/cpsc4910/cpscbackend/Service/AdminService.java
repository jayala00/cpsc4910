package com.cpsc4910.cpscbackend.Service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    String addAdmin(long id, String firstname, String lastname, String email, String password);
}
