package com.RentalCar.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "veicolo")
public class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroTelaio")
    @NotNull(message = "Il numero del telaio non può essere nullo")
    private int numeroTelaio;

    @Column(name = "targa")
    @NotNull(message = "La targa non può essere nulla")
    @Size(min=1, max=16, message = "Il targa deve contenere un minimo di 1 ed un massimo di 16 caratteri")
    private String targa;

    @Column(name = "casaCostruttrice")
    @NotNull(message = "La casa costruttirce non può essere nulla")
    @Size(min=1, max=25, message = "Il casa costruttrice deve contenere un minimo di 1 ed un massimo di 25 caratteri")
    private String casaCostruttrice;

    @Column(name = "modello")
    @NotNull(message = "Il modello non può essere nulla")
    private String modello;

    @Column(name = "tipologia")
    @NotNull(message = "La tipologia non può essere nulla")
    private String tipologia;

    @OneToOne(mappedBy = "veicolo", cascade = CascadeType.ALL)
    private Prenotazioni prenotazione;

    public int getNumeroTelaio() {
        return numeroTelaio;
    }

    public void setNumeroTelaio(int numeroTelaio) {
        this.numeroTelaio = numeroTelaio;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getCasaCostruttrice() {
        return casaCostruttrice;
    }

    public void setCasaCostruttrice(String casaCostruttrice) {
        this.casaCostruttrice = casaCostruttrice;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }


    @Override
    public String toString() {
        return "" + this.getTipologia()+", "+ this.getModello()+", " + this.getCasaCostruttrice();
    }

}
