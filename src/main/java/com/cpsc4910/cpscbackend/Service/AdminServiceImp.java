package com.cpsc4910.cpscbackend.Service;

import com.cpsc4910.cpscbackend.Admin.Admin;
import com.cpsc4910.cpscbackend.Admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
