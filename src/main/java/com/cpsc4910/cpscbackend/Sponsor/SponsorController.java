package com.cpsc4910.cpscbackend.Sponsor;


import com.cpsc4910.cpscbackend.Service.SponsorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping(path="/changepassword/{email}")
    public ResponseEntity<String> changeSponsorPassword(@PathVariable(value="email") String email, @Valid @RequestBody Sponsor request){
        return new ResponseEntity<>(sservice.changePassword(email, request.getPassword()),HttpStatus.OK);
    }

    @PostMapping(path="/changeemail/{email}")
    public ResponseEntity<String> changeSponsorEmail(@PathVariable(value="email") String email, @Valid @RequestBody Sponsor request){
        return new ResponseEntity<>(sservice.changeEmail(email , request.getEmail()), HttpStatus.OK);
    }

    @PostMapping(path="/changename/{email}")
    public ResponseEntity<String> changeSponsorName(@PathVariable(value="email") String email, @Valid @RequestBody Sponsor request){
        return new ResponseEntity<>(sservice.changeFirstname(email , request.getName()), HttpStatus.OK);
    }

    @PostMapping(path="/changeaddress/{email}")
    public ResponseEntity<String> changeSponsorAddress(@PathVariable(value="email") String email, @Valid @RequestBody Sponsor request){
        return new ResponseEntity<>(sservice.changeAddress(email , request.getAddress()), HttpStatus.OK);
    }

    @PostMapping(path="/changeid/{email}")
    public ResponseEntity<String> changeSponsorID(@PathVariable(value="email") String email, @Valid @RequestBody Sponsor request){
        return new ResponseEntity<>(sservice.changeID(email , request.getSponsorID()), HttpStatus.OK);
    }

    @GetMapping(path="/getSponsor/{email}")
    public ResponseEntity<Sponsor> getSponsorObject(@PathVariable(value="email") String email){
        return new ResponseEntity<>(sservice.getSponsor(email), HttpStatus.OK);
    }

    @GetMapping(path = "/getallsponsors")
    public ResponseEntity<Iterable<Sponsor>> getSponsors(){
        return new ResponseEntity<>(sservice.getAllSponsors(), HttpStatus.OK);
    }

    @PostMapping(path="/registersponsor")
    public ResponseEntity<String> registerNewSponsor(@Valid @RequestBody Sponsor request) {

        String response = sservice.registerSponsor(request.getName(), request.getEmail(), request.getPassword());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
