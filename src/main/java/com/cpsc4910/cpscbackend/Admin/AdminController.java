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

    @PostMapping("/addadmin")
    public ResponseEntity<String> addNewAdmin(@Valid @RequestBody Admin request) {

        String response = aservice.addAdmin(request.getAdminID(), request.getFirstname(), request.getLastname(), request.getEmail(), request.getPassword());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
