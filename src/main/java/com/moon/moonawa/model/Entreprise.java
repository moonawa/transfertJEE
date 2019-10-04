package com.moon.moonawa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String rs;

    @Column(length = 10)
    private String ninea;

    @Column(length = 10)
    private String adresse;

    @Column(length = 10)
    private String email;

    @Column(length = 10)
    private String telephone;

    @Column(length = 10)
    private String status;


    @OneToMany(mappedBy ="entreprise")
    //@JsonBackReference
    private List<User> users;

    public List<User> getUser() {
        return users;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

    @OneToMany(mappedBy ="entreprise")
    //@JsonBackReference
    private List<Compte> comptes;

    public List<Compte> getCompte() {
        return comptes;
    }

    public void setCompte(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

