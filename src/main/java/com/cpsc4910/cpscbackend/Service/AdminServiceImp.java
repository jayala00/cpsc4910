package com.cpsc4910.cpscbackend.Service;

import com.cpsc4910.cpscbackend.Admin.Admin;
import com.cpsc4910.cpscbackend.Admin.AdminRepository;
import com.cpsc4910.cpscbackend.Driver.DriverRepository;
import com.cpsc4910.cpscbackend.ResourceNotFoundException;
import com.cpsc4910.cpscbackend.Sponsor.SponsorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {
    private final AdminRepository adminRepository;
    private final DriverRepository driverRepository;
    private final SponsorRespository sponsorRespository;

    @Autowired
    public AdminServiceImp(AdminRepository adminRepository, DriverRepository driverRepository, SponsorRespository sponsorRespository) {
        this.adminRepository = adminRepository;
        this.driverRepository = driverRepository;
        this.sponsorRespository = sponsorRespository;
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

    public String getTotalNumberDrivers(){
        String answer;
        long totalDrivers = driverRepository.count();

        if (totalDrivers >= 0){
            answer = "There are no drivers registered in the system";
        }
        if (totalDrivers == 1){
            answer = "There is one driver registered in the system";
        }
        else {
            answer = "There are " + totalDrivers + " drivers registered in the system";
        }
        return answer;
    }

    public String getTotalNumberSponsors(){
        String answer;
        long totalDrivers = sponsorRespository.count();

        if (totalDrivers >= 0){
            answer = "There are no drivers registered in the system";
        }
        if (totalDrivers == 1){
            answer = "There is one driver registered in the system";
        }
        else {
            answer = "There are " + totalDrivers + " drivers registered in the system";
        }
        return answer;
    }



}
