package com.moon.moonawa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private int solde;


    private String no_compte;

    @JoinColumn(name = "entreprise_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    //@JsonManagedReference
    private Entreprise entreprise;

    @OneToMany(mappedBy ="compte")
    //@JsonBackReference
    private List<User> users;
    public List<User> getUser() {
        return users;
    }
    public void setUser(List<User> users) {
        this.users = users;
    }

    @OneToMany(mappedBy ="compte")
    //@JsonBackReference
    private List<Depot> depots;
    public List<Depot> getDepot() {
        return depots;
    }
    public void setDepot(List<Depot> depots) {
        this.depots = depots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getNo_compte() {
        return no_compte;
    }

    public void setNo_compte(String no_compte) {
        this.no_compte = no_compte;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
