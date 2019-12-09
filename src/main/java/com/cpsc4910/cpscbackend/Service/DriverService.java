package com.cpsc4910.cpscbackend.Service;


import com.cpsc4910.cpscbackend.Driver.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {

    String changePassword(String newPassword, String password);

    String addDriver(long driverID, String firstname, String lastname, String email, String address, String password);

    Driver getADriver(long id);

    ResponseEntity<?> deleteDriver(long id);

    Iterable<Driver> getAllDrivers();

    String getPassword(long id);

    String getEmail(long id);

    String changeEmail(String newemail, String email);

    String changeAddress(String newaddress, String email);

    String changeFirstname(String firstname, String email);

    String changeLastname(String lastname, String email);

    String changeDriverid(long driverid, String email);



    Driver getDriver(String email);

    Driver getDriverProfile(String email);

    String addPoints(int points, String email);

    String deletePoints(int points, String email);

    String registerDriver(String firstname, String lastname, String email, String password);

}
