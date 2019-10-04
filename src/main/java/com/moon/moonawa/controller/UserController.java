package com.moon.moonawa.controller;

import com.moon.moonawa.model.User;
import com.moon.moonawa.model.Role;
import com.moon.moonawa.repository.UserRepository;
import com.moon.moonawa.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserRepository userRepository;
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/liste")
    public List<User> liste() { return userRepository.findAll(); }


    @GetMapping(value = "/userr")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {

        return ">>> User Contents!";
    }


    @GetMapping("/caissier")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String caissier() {
        return ">>> Board Management Project";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public String admin() {
        return ">>> Admin Contents";
    }




}
