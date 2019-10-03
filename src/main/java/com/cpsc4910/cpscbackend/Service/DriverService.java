package com.cpsc4910.cpscbackend.Service;


import org.springframework.stereotype.Service;

@Service
public interface DriverService {

    String changePassword(String newPassword, long id);

    String addDriver(long id, long driverID, String firstname, String lastname, String password);

    String getAllDrivers();


}
