package com.cpsc4910.cpscbackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/driver")
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;

    @PostMapping(path="/adddrivers")
    public @ResponseBody String addNewDriver  (@RequestParam long id, @RequestParam String firstname, @RequestParam String lastname) {

        Driver d = new Driver();
        d.setDriverID(id);
        d.setFirstname(firstname);
        d.setLastname(lastname);
        driverRepository.save(d);

        return "Saved";
    }

    @GetMapping(path="/alldrivers")
    public @ResponseBody Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }


}
