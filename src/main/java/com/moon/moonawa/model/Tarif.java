package com.moon.moonawa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Tarif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private long borne_inferieur;

    @NotBlank
    private long borne_superieur;

    @NotBlank
    private long valeur;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBorne_inferieur() {
        return borne_inferieur;
    }

    public void setBorne_inferieur(long borne_inferieur) {
        this.borne_inferieur = borne_inferieur;
    }

    public long getBorne_superieur() {
        return borne_superieur;
    }

    public void setBorne_superieur(long borne_superieur) {
        this.borne_superieur = borne_superieur;
    }

    public long getValeur() {
        return valeur;
    }

    public void setValeur(long valeur) {
        this.valeur = valeur;
    }


}
