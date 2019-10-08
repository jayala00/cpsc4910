package com.cpsc4910.cpscbackend.Admin;

import com.cpsc4910.cpscbackend.Service.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping(path = "/changepassword/{id}")
    public ResponseEntity<String> changeAdminPassword(@PathVariable(value = "id") long id, @Valid @RequestBody Admin request){

        return new ResponseEntity<>(aservice.changePassword(id, request.getPassword()), HttpStatus.OK);
    }

    @PostMapping(path = "/changeemail/{id}")
    public ResponseEntity<String> changeAdminEmail(@PathVariable(value = "id") long id, @Valid @RequestBody Admin request){

        return new ResponseEntity<>(aservice.changeEmail(id, request.getEmail()), HttpStatus.OK);
    }

    @GetMapping(path="/getpassword/{id}")
    public ResponseEntity<String> getAdminPassword(@PathVariable(value = "id") long id){

        return new ResponseEntity<>(aservice.getPassword(id), HttpStatus.OK);
    }

    @GetMapping(path="/getemail/{id}")
    public ResponseEntity<String> getAdminEmail(@PathVariable(value = "id") long id){

        return new ResponseEntity<>(aservice.getEmail(id), HttpStatus.OK);
    }

    @DeleteMapping(path="/deleteadmin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") long id){
        return aservice.deleteAdmin(id);
    }
}
