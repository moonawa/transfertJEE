package com.moon.moonawa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "caissier_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    //@JsonManagedReference
    private User user;

    @JoinColumn(name = "compte_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    //@JsonManagedReference
    private Compte compte;

    @NotBlank
    @Column(length = 10)
    private String date;

    @NotBlank
    private Long montant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }


}
