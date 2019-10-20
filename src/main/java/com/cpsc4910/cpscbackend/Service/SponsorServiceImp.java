package com.cpsc4910.cpscbackend.Service;

import com.cpsc4910.cpscbackend.ResourceNotFoundException;
import com.cpsc4910.cpscbackend.Sponsor.Sponsor;
import com.cpsc4910.cpscbackend.Sponsor.SponsorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SponsorServiceImp implements SponsorService{
    private final SponsorRespository sponsorRespository;

    @Autowired
    public SponsorServiceImp(SponsorRespository sponsorRespository) {
        this.sponsorRespository = sponsorRespository;
    }

    public String addSponsor(long id, String name, String address, String password, String email){

        Sponsor sponsor = new Sponsor();

        sponsor.setSponsorID(id);
        sponsor.setName(name);
        sponsor.setAddress(address);
        sponsor.setPassword(password);
        sponsor.setEmail(email);
        sponsorRespository.save(sponsor);

        return "Sponsor " + " has been successfully registered";
    }

    public String changePassword(long id, String newpassword){
        Sponsor s = sponsorRespository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Sponsor", "id", id));

        s.setPassword(newpassword);
        sponsorRespository.save(s);
        return "Password Successfully Changed!";
    }

    public String changeEmail(long id, String newemail){
        Sponsor s = sponsorRespository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Sponsor", "id", id));

        s.setEmail(newemail);
        sponsorRespository.save(s);
        return "Email Successfully Changed";
    }
}
