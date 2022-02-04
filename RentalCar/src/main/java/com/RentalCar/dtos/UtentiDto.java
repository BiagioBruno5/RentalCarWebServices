package com.RentalCar.dtos;

import java.util.Date;

public class UtentiDto {

    public UtentiDto(){}

    public UtentiDto(int id, String nome, String cognome, Date dataNascita, Boolean isSuperUser, String pwd) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.isSuperUser = isSuperUser;
        this.password = pwd;
    }

    public UtentiDto(String nome, String cognome, Date dataNascita, Boolean isSuperUser, String pwd) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.isSuperUser = isSuperUser;
        this.password = pwd;
    }

    private int id;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private Boolean isSuperUser;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Boolean getSuperUser() {
        return isSuperUser;
    }

    public void setSuperUser(Boolean superUser) {
        isSuperUser = superUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
