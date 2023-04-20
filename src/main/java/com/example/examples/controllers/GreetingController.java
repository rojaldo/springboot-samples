package com.example.examples.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.examples.entities.UserEntity;
import com.example.examples.forms.BeerForm;
import com.example.examples.forms.UserForm;
import com.example.examples.requests.UserRequest;
import com.example.examples.services.BeersService;
import com.example.examples.services.UsersService;

import jakarta.validation.Valid;

@Controller
public class GreetingController {

    @Autowired
    private UsersService users;

    @Autowired
    private BeersService beers;
    
    @GetMapping("/greeting")
    public String greeting(
        @RequestParam(name="name", required=false, defaultValue="World") String name, 
        Model view) {
            // iterable to list
            ArrayList list = (ArrayList) ((Collection) this.users.getUsers()).stream().collect(Collectors.toList());

            System.out.println(list);
            
        view.addAttribute("message", name);
        view.addAttribute("users", list);
        return "greeting";
    }


    @GetMapping("/greeting/{name}/info")
    public String greetingPath(
        @PathVariable String name, 
        Model view) {
        view.addAttribute("message", name);
        return "greeting";
    }

    // @GetMapping("/newuser")
    // public String newUser(Model view) {
    //     view.addAttribute("user", new UserForm());
    //     return "newuser";
    // }

    // @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    // public String saveStudent(@ModelAttribute("user") @Valid UserForm userForm, BindingResult errors, Model model) {
    //     if (errors.hasErrors()) {
    //         return "error";
    //     }
    //     UserRequest user = new UserRequest(userForm.getName(), userForm.getEmail());
    //     this.users.createUser(user);
    //     return "redirect:/greeting";

    // }

    @GetMapping("/beers")
    public String beers(Model view) {
        view.addAttribute("beers", this.beers.getBeers());
        return "beers";
    }

    @GetMapping("/newbeer")
    public String newBeer(Model view) {
        view.addAttribute("beer", new BeerForm());
        return "newbeer";
    }

    @PostMapping("/newbeer")
    public String saveBeer(@ModelAttribute("beer") @Valid BeerForm beerForm, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "error";
        }
        this.beers.createBeer(beerForm);
        return "redirect:/beers";

    }
   
}
