package com.moon.moonawa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
public class Retrait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(length = 10)
    private String code;

    @NotBlank
    @Column(length = 10)
    private String date_reception;

    @NotBlank
    @Column(length = 10)
    private String etat;

    @NotBlank
    private Long commission_envoi;

    @NotBlank
    private Long commission_receveur;

    @NotBlank
    private Long commission_moon;

    @NotBlank
    private Long taxe_etat;

    @JoinColumn(name = "user_receveur",referencedColumnName ="id")
    @ManyToOne(optional = false)
    //@JsonManagedReference
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate_reception() {
        return date_reception;
    }

    public void setDate_reception(String date_reception) {
        this.date_reception = date_reception;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Long getCommission_envoi() {
        return commission_envoi;
    }

    public void setCommission_envoi(Long commission_envoi) {
        this.commission_envoi = commission_envoi;
    }

    public Long getCommission_receveur() {
        return commission_receveur;
    }

    public void setCommission_receveur(Long commission_receveur) {
        this.commission_receveur = commission_receveur;
    }

    public Long getCommission_moon() {
        return commission_moon;
    }

    public void setCommission_moon(Long commission_moon) {
        this.commission_moon = commission_moon;
    }

    public Long getTaxe_etat() {
        return taxe_etat;
    }

    public void setTaxe_etat(Long taxe_etat) {
        this.taxe_etat = taxe_etat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
