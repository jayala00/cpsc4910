package com.cpsc4910.cpscbackend.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository ShoppingcartRepository;

    @PostMapping(path="/addcart")
    public @ResponseBody String addShoppingCart  (@RequestParam String unique) {

        ShoppingCart s = new ShoppingCart();
        s.setUniqueID(unique);
        ShoppingcartRepository.save(s);

        return "Saved";


    }

    @GetMapping(path="/allcarts")
    public @ResponseBody Iterable<ShoppingCart> getAllShoppingCarts() {
        return ShoppingcartRepository.findAll();
    }


}
