package com.cpsc4910.cpscbackend.Service;


import com.cpsc4910.cpscbackend.Driver.Driver;
import com.cpsc4910.cpscbackend.Driver.DriverRepository;
import com.cpsc4910.cpscbackend.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImp implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImp(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public String changePassword(String newPassword, long id) {

        Driver d = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        d.setPassword(newPassword);

        driverRepository.save(d);

        return "Password Successfully Changed To " + newPassword;


    }

    public String addDriver(long id, long driverID, String firstname, String lastname, String password) {

        Driver d = new Driver();

        d.setID(id);
        d.setDriverID(driverID);
        d.setFirstname(firstname);
        d.setLastname(lastname);
        d.setPassword(password);

        driverRepository.save(d);

        return "Driver " + firstname + " has been added!";
    }

    public Driver getADriver(long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));
    }

    public ResponseEntity<?> deleteDriver(long id) {
        Driver d = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        driverRepository.delete(d);

        return ResponseEntity.ok().build();
    }

    public Iterable<Driver> getAllDrivers(){
        return  driverRepository.findAll();
    }

    public String getPassword(long id){
        Driver d = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        return d.getPassword();
    }

    public String getEmail(long id){
        Driver d = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        return d.getEmail();
    }

    public String changeEmail(String newemail, long id){
        Driver d = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        d.setEmail(newemail);

        driverRepository.save(d);

        return "Email Successfully Changed To " + newemail;
    }
}
