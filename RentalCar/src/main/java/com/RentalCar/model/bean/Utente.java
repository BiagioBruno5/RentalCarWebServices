package com.RentalCar.model.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
@XmlRootElement
public class Utente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    @NotNull(message = "Il nome non può essere nullo")
    @Size(min=1, max=10, message = "Il nome deve contenere un minimo di 1 ed un massimo di 10 caratteri")
    private String nome;

    @Column(name = "cognome")
    @NotNull(message = "Il cognome non può essere nullo")
    @Size(min=1, max=10, message = "Il cognome deve contenere un minimo di 1 ed un massimo di 10 caratteri")
    private String cognome;

    @Column(name = "dataNascita")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La data di nascita non può essere nulla")
    private Date dataNascita;

    @Column(name = "password")
    @NotNull(message = "La password non può essere nulla")
    private String password;

    @Column(name = "isSuperUser")
    private Boolean isSuperUser;

    @OneToMany(mappedBy="utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.RentalCar.model.bean.Prenotazioni> prenotazioni;

    public Utente(){

    }

    public Boolean is_SuperUser(){
        if(this.getIsSuperUser() == true){
            return true;
        }
        return false;
    }

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

    public Boolean getIsSuperUser() {
        return isSuperUser;
    }

    public void setIsSuperUser(Boolean superUser) {
        isSuperUser = superUser;
    }

    public List<com.RentalCar.model.bean.Prenotazioni> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<com.RentalCar.model.bean.Prenotazioni> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", isSuperUser=" + isSuperUser +
                ", prenotazioni=" + prenotazioni +
                '}';
    }
}
