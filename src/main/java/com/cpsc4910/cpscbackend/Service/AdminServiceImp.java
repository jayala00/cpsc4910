package com.cpsc4910.cpscbackend.Service;

import com.cpsc4910.cpscbackend.Admin.Admin;
import com.cpsc4910.cpscbackend.Admin.AdminRepository;
import com.cpsc4910.cpscbackend.Driver.Driver;
import com.cpsc4910.cpscbackend.Driver.DriverRepository;
import com.cpsc4910.cpscbackend.ResourceNotFoundException;
import com.cpsc4910.cpscbackend.Sponsor.Sponsor;
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

    public String addDriver(long id, long driverID, String firstname, String lastname, String email, String address, String password) {

        Driver d = new Driver();

        d.setID(id);
        d.setDriverID(driverID);
        d.setFirstname(firstname);
        d.setLastname(lastname);
        d.setEmail(email);
        d.setAddress(address);
        d.setPassword(password);

        driverRepository.save(d);

        return "Driver " + firstname + " has been added!";
    }

    public String addSponsor(long id, String name, String address, String password, String email){

        Sponsor sponsor = new Sponsor();

        sponsor.setSponsorID(id);
        sponsor.setName(name);
        sponsor.setAddress(address);
        sponsor.setPassword(password);
        sponsor.setEmail(email);
        sponsorRespository.save(sponsor);

        return "Sponsor " + " has been successfully registered";
    }

    public ResponseEntity<?> deleteAdmin(long id){
        Admin a = adminRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));

        adminRepository.delete(a);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteDriver(long id){
        Driver d = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        driverRepository.delete(d);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteSponsor(long id){
        Sponsor s = sponsorRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));

        sponsorRespository.delete(s);

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

    public Boolean checkIfUserExists(String email){
        Admin a = adminRepository.findByEmail(email);
        boolean check = false;
        if ( a != null){
            check = true;
        }

        return check;



    }

    public Admin getAdmin(String email){
        return adminRepository.findByEmail(email);
    }


    public Iterable<Admin> getAllAdmin(){
        return  adminRepository.findAll();
    }

    public String registerAdmin (String firstname, String lastname, String email, String password) {

        Admin a = new Admin();

        a.setEmail(email);
        a.setFirstname(firstname);
        a.setLastname(lastname);
        a.setPassword(password);
        a.setAdminID(0);

        adminRepository.save(a);

        return "Admin " + firstname + " has been added!";
    }
}
