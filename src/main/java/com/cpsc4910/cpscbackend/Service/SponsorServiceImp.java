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

    public String changePassword(String email, String newpassword){
        Sponsor s = sponsorRespository.findByEmail(email);

        s.setPassword(newpassword);
        sponsorRespository.save(s);
        return "Password Successfully Changed!";
    }

    public String changeEmail(String email, String newemail){
        Sponsor s = sponsorRespository.findByEmail(email);

        s.setEmail(newemail);
        sponsorRespository.save(s);
        return "Email Successfully Changed";
    }

    public String changeFirstname(String email, String newname){
        Sponsor s = sponsorRespository.findByEmail(email);

        s.setName(newname);
        sponsorRespository.save(s);
        return "Email Successfully Changed";
    }

    public String changeID(String email, long id){
        Sponsor s = sponsorRespository.findByEmail(email);

        s.setSponsorID(id);
        sponsorRespository.save(s);
        return "Email Successfully Changed";
    }

    public String changeAddress(String email, String newaddress){
        Sponsor s = sponsorRespository.findByEmail(email);

        s.setAddress(newaddress);
        sponsorRespository.save(s);
        return "Email Successfully Changed";
    }

    public Sponsor getSponsor(String email){
        return sponsorRespository.findByEmail(email);
    }

    public Iterable<Sponsor> getAllSponsors(){
        return  sponsorRespository.findAll();
    }

    public String registerSponsor (String name, String email, String password) {

        Sponsor s = new Sponsor();

        s.setEmail(email);
        s.setPassword(password);
        s.setAddress(null);
        s.setName(name);
        s.setSponsorID(0);

        sponsorRespository.save(s);

        return "Sponsor " + name + " has been added!";
    }
}
