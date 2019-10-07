package com.cpsc4910.cpscbackend.Service;


import com.cpsc4910.cpscbackend.Driver.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {

    String changePassword(String newPassword, long id);

    String addDriver(long id, long driverID, String firstname, String lastname, String password);

    Driver getADriver(long id);

    ResponseEntity<?> deleteDriver(long id);

    Iterable<Driver> getAllDrivers();

    String getPassword(long id);

    String getEmail(long id);

    String changeEmail(String newemail, long id);


}
