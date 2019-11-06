package com.cpsc4910.cpscbackend.Sponsor;


import com.cpsc4910.cpscbackend.Service.SponsorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/sponsor")
public class SponsorController {

    private final SponsorServiceImp sservice;

    @Autowired
    public SponsorController(SponsorServiceImp sservice) {
        this.sservice = sservice;
    }



    @PostMapping(path="/addsponsor")
    public ResponseEntity<String> addNewSponsor(@Valid @RequestBody Sponsor request){
        String response = sservice.addSponsor(request.getSponsorID(), request.getName(), request.getAddress(), request.getPassword(), request.getEmail());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path="/changepassword/{id}")
    public ResponseEntity<String> changeSponsorPassword(@PathVariable(value="id") long id, @Valid @RequestBody Sponsor request){
        return new ResponseEntity<>(sservice.changePassword(id, request.getPassword()),HttpStatus.OK);
    }

    @PostMapping(path="/changeemail/{id}")
    public ResponseEntity<String> changeSponsorEmail(@PathVariable(value="id")long id, @Valid @RequestBody Sponsor request){
        return new ResponseEntity<>(sservice.changeEmail(id , request.getEmail()), HttpStatus.OK);
    }

    @GetMapping(path="/getSponsor/{email}")
    public ResponseEntity<Sponsor> getSponsorObject(@PathVariable(value="email") String email){
        return new ResponseEntity<>(sservice.getSponsor(email), HttpStatus.OK);
    }


}
