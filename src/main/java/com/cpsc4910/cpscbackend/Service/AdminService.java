package com.cpsc4910.cpscbackend.Service;

import com.cpsc4910.cpscbackend.Admin.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    String addAdmin(long id, String firstname, String lastname, String email, String password);

    ResponseEntity<?> deleteAdmin(long id);

    String addDriver(long id, long driverID, String firstname, String lastname, String email, String address, String password);

    ResponseEntity<?> deleteDriver(long id);

    String addSponsor(long id, String name, String address, String password, String email);

    ResponseEntity<?> deleteSponsor(long id);

    String getEmail(long id);

    String getPassword(long id);

    String changePassword(String email, String newpassword);

    String changeEmail(String email, String newemail);

    String changeFirst(String email, String firstname);

    String changeLast(String email, String lastname);

    String changeID(String email, long id);

    String getTotalNumberDrivers();

    String getTotalNumberSponsors();

    Boolean checkIfUserExists(String email);

    Admin getAdmin(String email);

    Iterable<Admin> getAllAdmin();

    String registerAdmin(String firstname, String lastname, String email, String password);
}
