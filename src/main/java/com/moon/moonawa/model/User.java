package com.moon.moonawa.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String telephone;

    @NotBlank
    private String nci;

    @NotBlank

    private String status;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    private String photo;

    @JoinColumn(name = "entreprise_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    //@JsonManagedReference
    private Entreprise entreprise;

    @JoinColumn(name = "compte_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    //@JsonManagedReference
    private Compte compte;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))


    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(String name, String username, String email, String password, String telephone, String nci, String status, String photo) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.telephone = telephone;
        this.nci = nci;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {return photo;}

    public void setPhoto(String photo) {this.photo = photo;}

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }


}
