package com.cpsc4910.cpscbackend.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    String addAdmin(long id, String firstname, String lastname, String email, String password);

    ResponseEntity<?> deleteAdmin(long id);

    String getEmail(long id);

    String getPassword(long id);

    String changePassword(long id, String newpassword);

    String changeEmail(long id, String newemail);
}
