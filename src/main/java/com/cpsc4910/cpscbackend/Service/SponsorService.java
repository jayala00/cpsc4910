package com.cpsc4910.cpscbackend.Service;

import com.cpsc4910.cpscbackend.Sponsor.Sponsor;
import org.springframework.stereotype.Service;

@Service
public interface SponsorService {
    String addSponsor(long id, String name, String address, String password, String email);

    String changePassword(String email, String newpassword);

    String changeEmail(String email, String newemail);

    String changeFirstname(String email, String newname);

    String changeID(String email, long id);

    String changeAddress(String email, String newaddress);

    Sponsor getSponsor(String email);

    Iterable<Sponsor> getAllSponsors();

    String registerSponsor(String name, String email, String password);
}
