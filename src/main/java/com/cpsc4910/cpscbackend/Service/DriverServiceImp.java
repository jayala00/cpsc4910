package com.cpsc4910.cpscbackend.Service;


import com.cpsc4910.cpscbackend.Driver.Driver;
import com.cpsc4910.cpscbackend.Driver.DriverRepository;
import com.cpsc4910.cpscbackend.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImp implements DriverService{

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImp(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public String changePassword(String newPassword, long id){

        Driver d = driverRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Driver","id",id));

        d.setPassword(newPassword);

        driverRepository.save(d);

        return "Password Changed";


    }

    public String addDriver(long id, long driverID, String firstname, String lastname, String password){

        Driver d = new Driver();

        d.setID(id);
        d.setDriverID(driverID);
        d.setFirstname(firstname);
        d.setLastname(lastname);
        d.setPassword(password);

        driverRepository.save(d);

        return "Driver " + firstname + " has been added!";
    }

    public String getAllDrivers(){
        return "sotmething";
    }
}
