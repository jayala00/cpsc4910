package com.cpsc4910.cpscbackend.Driver;


import com.cpsc4910.cpscbackend.Service.DriverServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/driver")
public class DriverController {

    private final DriverServiceImp dservice;

    @Autowired
    public DriverController(DriverServiceImp dservice) {

        this.dservice = dservice;
    }

    @PostMapping(path = "/adddrivers")
    public ResponseEntity<String> addNewDriver(@Valid @RequestBody Driver request) {

        String response = dservice.addDriver(request.getID(), request.getDriverID(), request.getFirstname(), request.getLastname(), request.getPassword());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/changepassword/{id}")
    public ResponseEntity<String> changeDriverPassword(@PathVariable(value = "id") long id, @Valid @RequestBody Driver request) {

        String response = dservice.changePassword(request.getPassword(), id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/changeemail/{id}")
    public ResponseEntity<String> changeDriverEmail(@PathVariable(value = "id") long id, @Valid @RequestBody Driver request) {

        String response = dservice.changeEmail(request.getEmail(), id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/getdriver/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable(value = "id") long id) {

        return new ResponseEntity<>(dservice.getADriver(id),HttpStatus.OK);
    }

    @GetMapping(path = "/getPassword/{id}")
    public ResponseEntity<String> getDriverPassword(@PathVariable(value = "id") long id){

        return new ResponseEntity<>(dservice.getPassword(id), HttpStatus.OK);
    }

    @GetMapping(path = "/getEmail/{id}")
    public ResponseEntity<String> getDriverEmail(@PathVariable(value = "id") long id){

        return new ResponseEntity<>(dservice.getEmail(id), HttpStatus.OK);
    }

    @GetMapping(path = "/getalldrivers")
    public ResponseEntity<Iterable<Driver>> getDrivers(){
        return new ResponseEntity<>(dservice.getAllDrivers(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletedriver/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable(value = "id") long id) {
        return dservice.deleteDriver(id);
    }



}
