package com.cpsc4910.cpscbackend.Driver;


import com.cpsc4910.cpscbackend.Service.DriverServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path="/driver")
public class DriverController {

    private final DriverServiceImp dservice;

    @Autowired
    public DriverController(DriverServiceImp dservice) {
        this.dservice = dservice;
    }

    @PostMapping(path="/adddrivers")
    public ResponseEntity<?> addNewDriver  (@Valid @RequestBody Driver request ) {

       String response = dservice.addDriver(request.getID(), request.getDriverID(), request.getFirstname(), request.getLastname(), request.getPassword());

       return new ResponseEntity<>(response, HttpStatus.OK);


    }

    /*
    @GetMapping(path="/alldrivers")
    public Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping(path="/find/{id}")
    public Driver getDriverById(@PathVariable(value = "id") long id ){
        return driverRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

    }*/

    @PostMapping(path="/changepassword/{id}")
    public ResponseEntity<?> changeDriverPassword(@PathVariable(value="id") long id, @Valid @RequestBody DeleteDriverPassword request){

        String response = dservice.changePassword(request.getChangePassword(), id);

        return new ResponseEntity<>(response , HttpStatus.OK);

    }

    /*@DeleteMapping(path="/deletedriver/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable(value = "id") long id) {
        Driver d = driverRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        driverRepository.delete(d);

        return ResponseEntity.ok().build();

    }*/

}
