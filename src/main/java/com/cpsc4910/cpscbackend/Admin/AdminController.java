package com.cpsc4910.cpscbackend.Admin;

import com.cpsc4910.cpscbackend.Driver.Driver;
import com.cpsc4910.cpscbackend.Service.AdminServiceImp;
import com.cpsc4910.cpscbackend.Sponsor.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(path="/admin")
public class AdminController {

    private final AdminServiceImp aservice;

    @Autowired
    public AdminController(AdminServiceImp aservice) {
        this.aservice = aservice;
    }

    @PostMapping(path="/addadmin")
    public ResponseEntity<String> addNewAdmin(@Valid @RequestBody Admin request) {

        String response = aservice.addAdmin(request.getAdminID(), request.getFirstname(), request.getLastname(), request.getEmail(), request.getPassword());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path="/adddriver")
    public ResponseEntity<String> addNewDriver(@Valid @RequestBody Driver request) {

        String response = aservice.addDriver(request.getID(), request.getDriverID(), request.getFirstname(), request.getLastname(), request.getEmail(), request.getAddress(), request.getPassword());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path="/addsponsor")
    public ResponseEntity<String> addNewSponsor(@Valid @RequestBody Sponsor request){
        String response = aservice.addSponsor(request.getSponsorID(), request.getName(), request.getAddress(), request.getPassword(), request.getEmail());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/changepassword/{email}")
    public ResponseEntity<String> changeAdminPassword(@PathVariable(value = "email") String email, @Valid @RequestBody Admin request){

        return new ResponseEntity<>(aservice.changePassword(email, request.getPassword()), HttpStatus.OK);
    }

    @PostMapping(path = "/changeemail/{email}")
    public ResponseEntity<String> changeAdminEmail(@PathVariable(value = "email") String email, @Valid @RequestBody Admin request){

        return new ResponseEntity<>(aservice.changeEmail(email, request.getEmail()), HttpStatus.OK);
    }

    @PostMapping(path = "/changefirstname/{email}")
    public ResponseEntity<String> changeAdminfirstname(@PathVariable(value = "email") String email, @Valid @RequestBody Admin request){

        return new ResponseEntity<>(aservice.changeFirst(email, request.getFirstname()), HttpStatus.OK);
    }

    @PostMapping(path = "/changelastname/{email}")
    public ResponseEntity<String> changeAdminlastname(@PathVariable(value = "email") String email, @Valid @RequestBody Admin request){

        return new ResponseEntity<>(aservice.changeLast(email, request.getLastname()), HttpStatus.OK);
    }

    @PostMapping(path = "/changeid/{email}")
    public ResponseEntity<String> changeAdminID(@PathVariable(value = "email") String email, @Valid @RequestBody Admin request){

        return new ResponseEntity<>(aservice.changeID(email, request.getAdminID()), HttpStatus.OK);
    }

    @GetMapping(path="/getpassword/{id}")
    public ResponseEntity<String> getAdminPassword(@PathVariable(value = "id") long id){

        return new ResponseEntity<>(aservice.getPassword(id), HttpStatus.OK);
    }

    @GetMapping(path="/getemail/{id}")
    public ResponseEntity<String> getAdminEmail(@PathVariable(value = "id") long id){

        return new ResponseEntity<>(aservice.getEmail(id), HttpStatus.OK);
    }

    @GetMapping(path="/gettotnumdrivers")
    public ResponseEntity<String> getTotalNumDrivers(){
        return new ResponseEntity<>(aservice.getTotalNumberDrivers(), HttpStatus.OK);
    }

    @GetMapping(path="/gettotnumsponsors")
    public ResponseEntity<String> getTotalNumSponsors(){
        return new ResponseEntity<>(aservice.getTotalNumberSponsors(), HttpStatus.OK);
    }

    @GetMapping(path="/adminexists/{email}")
    public ResponseEntity<Boolean> checkIfAdminExists(@PathVariable(value = "email") String email){
        return new ResponseEntity<>(aservice.checkIfUserExists(email), HttpStatus.OK);
    }

    @GetMapping(path="/getAdmin/{email}")
    public ResponseEntity<Admin> getAdminObject(@PathVariable(value = "email") String email){
        return new ResponseEntity<>(aservice.getAdmin(email), HttpStatus.OK);
    }

    @GetMapping(path = "/getalladmin")
    public ResponseEntity<Iterable<Admin>> getAdmin(){
        return new ResponseEntity<>(aservice.getAllAdmin(), HttpStatus.OK);
    }

    @DeleteMapping(path="/deleteadmin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") long id){
        return aservice.deleteAdmin(id);
    }

    @DeleteMapping(path="/deletedriver/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable(value = "id") long id){
        return aservice.deleteDriver(id);
    }

    @DeleteMapping(path="/deletesponsor/{id}")
    public ResponseEntity<?> deleteSponsor(@PathVariable(value = "id") long id){
        return aservice.deleteSponsor(id);
    }

    @PostMapping(path="/registeradmin")
    public ResponseEntity<String> registerNewAdmin(@Valid @RequestBody Admin request) {

        String response = aservice.registerAdmin(request.getFirstname(), request.getLastname(), request.getEmail(), request.getPassword());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
