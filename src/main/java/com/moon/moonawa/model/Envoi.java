package com.moon.moonawa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Envoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(length = 10)
    private String envoyeur;

    @NotBlank
    @Column(length = 10)
    private String tel_envoyeur;

    @NotBlank
    @Column(length = 10)
    private String nci_envoyeur;

    @NotBlank
    @Column(length = 10)
    private String receveur;

    @NotBlank
    @Column(length = 10)
    private String tel_receveur;

    @JoinColumn(name = "user_envoyeur",referencedColumnName ="id")
    @ManyToOne(optional = false)
    //@JsonManagedReference
    private User user;

    @NotBlank
    private Long montant;

    @NotBlank
    @Column(length = 10)
    private String frais;

    @NotBlank
    @Column(length = 10)
    private String code;

    @NotBlank
    @Column(length = 10)
    private String date_envoi;

    @NotBlank
    @Column(length = 10)
    private String etat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnvoyeur() {
        return envoyeur;
    }

    public void setEnvoyeur(String envoyeur) {
        this.envoyeur = envoyeur;
    }

    public String getTel_envoyeur() {
        return tel_envoyeur;
    }

    public void setTel_envoyeur(String tel_envoyeur) {
        this.tel_envoyeur = tel_envoyeur;
    }

    public String getNci_envoyeur() {
        return nci_envoyeur;
    }

    public void setNci_envoyeur(String nci_envoyeur) {
        this.nci_envoyeur = nci_envoyeur;
    }

    public String getReceveur() {
        return receveur;
    }

    public void setReceveur(String receveur) {
        this.receveur = receveur;
    }

    public String getTel_receveur() {
        return tel_receveur;
    }

    public void setTel_receveur(String tel_receveur) {
        this.tel_receveur = tel_receveur;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public String getFrais() {
        return frais;
    }

    public void setFrais(String frais) {
        this.frais = frais;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(String date_envoi) {
        this.date_envoi = date_envoi;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


}
