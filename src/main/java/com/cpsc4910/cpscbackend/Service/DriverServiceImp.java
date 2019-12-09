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

    public String addDriver(long driverID, String firstname, String lastname, String email, String address, String password) {

        Driver d = new Driver();

        d.setDriverID(driverID);
        d.setFirstname(firstname);
        d.setLastname(lastname);
        d.setEmail(email);
        d.setAddress(address);
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

    public String addPoints(int points, String email){
        Driver d = driverRepository.findByEmail(email);

        int oldpoints = d.getPoints();

        int newpoints = oldpoints + points;

        d.setPoints(newpoints);

        driverRepository.save(d);

        return "Points added to " + email + " : " + points;

    }

    public String deletePoints(int points, String email){
        Driver d = driverRepository.findByEmail(email);

        int oldpoints = d.getPoints();

        int newpoints = oldpoints - points;

        if (newpoints < 0){
            newpoints = 0;
        }

        d.setPoints(newpoints);

        driverRepository.save(d);

        return "Points added to " + email + " : " + points;

    }

    public String changeAddress(String newaddress, long id){
        Driver d = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        d.setAddress(newaddress);

        driverRepository.save(d);

        return "Address Successfully Changed To " + newaddress;
    }

    public Driver getDriver(String email){
        return driverRepository.findByEmail(email);
    }

    public Driver getDriverProfile(String email) { return  driverRepository.findByEmail(email); }

    public String registerDriver (String firstname, String lastname, String email, String password) {

        Driver d = new Driver();

        d.setID(0);
        d.setDriverID(0);
        d.setFirstname(firstname);
        d.setLastname(lastname);
        d.setEmail(email);
        d.setAddress(null);
        d.setPassword(password);

        driverRepository.save(d);

        return "Driver " + firstname + " has been added!";
    }
}
