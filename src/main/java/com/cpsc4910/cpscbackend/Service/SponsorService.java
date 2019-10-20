package com.cpsc4910.cpscbackend.Service;

import org.springframework.stereotype.Service;

@Service
public interface SponsorService {
    String addSponsor(long id, String name, String address, String password, String email);

    String changePassword(long id, String newpassword);

    String changeEmail(long id, String newemail);
}