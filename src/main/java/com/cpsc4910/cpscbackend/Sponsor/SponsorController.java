package com.cpsc4910.cpscbackend.Sponsor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/sponsor")
public class SponsorController {

    @Autowired
    private SponsorRespository sponsorRespository;

    @PostMapping(path="/addsponsor")
    public @ResponseBody String newSponsor (@RequestParam long id, @RequestParam String name, @RequestParam String address, @RequestParam String pass){

        Sponsor sponsor = new Sponsor();
        sponsor.setSponsorID(id);
        sponsor.setName(name);
        sponsor.setAddress(address);
        sponsor.setPassword(pass);
        sponsorRespository.save(sponsor);

        return "Saved";
    }

    @GetMapping(path="/allsponsors")
    public @ResponseBody Iterable<Sponsor> getAllSponsors() {
        return sponsorRespository.findAll();
    }



}
