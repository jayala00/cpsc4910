package com.cpsc4910.cpscbackend.Service;

import com.cpsc4910.cpscbackend.Admin.Admin;
import com.cpsc4910.cpscbackend.Admin.AdminRepository;
import com.cpsc4910.cpscbackend.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImp(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public String addAdmin(long id, String firstname, String lastname, String email, String password){

        Admin a = new Admin();

        a.setAdminID(id);
        a.setFirstname(firstname);
        a.setLastname(lastname);
        a.setEmail(email);
        a.setPassword(password);

        adminRepository.save(a);

        return "Admin " + firstname + " has been registered!";
    }

    public ResponseEntity<?> deleteAdmin(long id){
        Admin a = adminRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));

        adminRepository.delete(a);

        return ResponseEntity.ok().build();
    }

    public String getEmail(long id){
        Admin a = adminRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));

        return a.getEmail();
    }

    public String getPassword(long id){
        Admin a = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));

        return a.getPassword();
    }

    public String changePassword(long id, String newpassword){
        Admin a = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));

        a.setPassword(newpassword);

        adminRepository.save(a);

        return "Password Successfully Changed";
    }

    public String changeEmail(long id, String newemail){
        Admin a = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));

        a.setEmail(newemail);

        adminRepository.save(a);

        return "Email Successfully Changed";
    }
}
