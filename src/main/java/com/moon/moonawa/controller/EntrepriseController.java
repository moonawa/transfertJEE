package com.moon.moonawa.controller;

import com.moon.moonawa.model.*;
import com.moon.moonawa.repository.EntrepriseRepository;
import com.moon.moonawa.repository.RoleRepository;
import com.moon.moonawa.repository.UserRepository;
import com.moon.moonawa.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/entreprise")
public class EntrepriseController {
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Entreprise> liste() { return entrepriseRepository.findAll(); }
    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public  Entreprise add(@RequestBody(required = false) Entreprise e){return entrepriseRepository.save(e);}



    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @PostMapping(value = "/addEntreprise", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public Entreprise add(@RequestBody(required = false) RegistrationEntreprise registrationEntreprise) {

        //AJOUT PARTENAIRE
        Entreprise e = new Entreprise();
        e.setEmail(registrationEntreprise.getEmail());
        e.setRs(registrationEntreprise.getRs());
        e.setNinea(registrationEntreprise.getNinea());
        e.setAdresse(registrationEntreprise.getAdresse());

        e.setTelephone(registrationEntreprise.getTelephone());
        e.setStatus("Actif");
        entrepriseRepository.save(e);

        //AJOUT COMPTE
        Compte c = new Compte();
        //String nb;
        //nb = "MA"+(10000+(int) Math.random()*(99999-10000));
        //c.setNo_compte(nb);

        //SimpleDateFormat formater = null;
        //formater = new SimpleDateFormat("ssyyyyMMddHHmm");
        //Date now=new Date();
        //String numcompt = formater.format(now);
        c.setNo_compte("MA");

        c.setEntreprise(e);
        c.setSolde(75000);
        compteRepository.save(c);

        //AJOUT UTILISATEUR
        User u = new User();
        u.setUsername(registrationEntreprise.getUsername());
        u.setName(registrationEntreprise.getName());
        u.setPassword(encoder.encode(registrationEntreprise.getPassword()));
        u.setTelephone(registrationEntreprise.getTelephone());
        u.setStatus("Actif");
        u.setEmail(registrationEntreprise.getEmail());
        u.setNci(registrationEntreprise.getNci());
        u.setPhoto(registrationEntreprise.getPhoto());
        u.setCompte(c);
        u.setEntreprise(e);

      //  Set<String> strRoles = registrationEntreprise.getRole();
        Set<Role> roles = new HashSet<>();

        Role adminRole = roleRepository.findByName(RoleName.ROLE_SUPERADMIN)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(adminRole);

        //roles.add(role);
        u.setRoles(roles);


        u.setEntreprise(e);
        u.setCompte(c);
        userRepository.save(u);

        return entrepriseRepository.save(e);
    }


}
