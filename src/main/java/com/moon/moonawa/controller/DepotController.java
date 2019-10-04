package com.moon.moonawa.controller;

import com.moon.moonawa.model.Compte;
import com.moon.moonawa.model.Depot;
import com.moon.moonawa.model.User;
import com.moon.moonawa.repository.CompteRepository;
import com.moon.moonawa.repository.DepotRepository;
import com.moon.moonawa.repository.RoleRepository;
import com.moon.moonawa.repository.UserRepository;
import com.moon.moonawa.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/deposer")
public class DepotController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DepotRepository depotRepository;

    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @PostMapping(value = "/depot", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public Depot add(@RequestBody(required = false) Depot depot) {
        User thisUser = userDetailsService.getUserconnected();
        Depot d = new Depot();

        d.setMontant(depot.getMontant());
        d.setDate(depot.getDate());
        d.setUser(thisUser);
        d.setCompte(depot.getCompte());



        return depotRepository.save(d);

    }
}
