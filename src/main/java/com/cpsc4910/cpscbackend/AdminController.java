package com.cpsc4910.cpscbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/addadmin")
    public @ResponseBody String addNewAdmin(@RequestParam String id, @RequestParam String firstname, @RequestParam String lastname) {
        Admin admin = new Admin();
        admin.setAdminID(id);
        admin.setFirstname(firstname);
        admin.setLastname(lastname);
        adminRepository.save(admin);

        return "Saved";
    }
}
