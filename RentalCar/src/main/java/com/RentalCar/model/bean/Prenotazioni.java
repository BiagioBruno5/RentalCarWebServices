package com.RentalCar.model.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroPrenotazione")
    private int numeroPrenotazione;

    @Column(name = "dataInizio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La data di inizio non può essere nulla")
    private Date dataInizio;

    @Column(name = "dataFine")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La data di fine non può essere nulla")
    private Date dataFine;

    @Column(name = "approvazione")
    private Boolean approvazione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id", nullable=false)
    private Utente utente;

    @OneToOne
    @JoinTable(name = "prenotazione_veicolo",
            joinColumns =
                    { @JoinColumn(name = "prenotazioni_id", referencedColumnName = "numeroPrenotazione") },
            inverseJoinColumns =
                    { @JoinColumn(name = "veicolo_id", referencedColumnName = "numeroTelaio") })
    private Veicolo veicolo;

    public Prenotazioni(){

    }

    public int getNumeroPrenotazione() {
        return numeroPrenotazione;
    }


    public void setNumeroPrenotazione(int numeroPrenotazione) {
        this.numeroPrenotazione = numeroPrenotazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public Boolean getApprovazione() {
        return approvazione;
    }

    public void setApprovazione(Boolean approvazione) {
        this.approvazione = approvazione;
    }

    @Override
    public String toString() {
        return "Prenotazioni{" +
                "numeroPrenotazione=" + numeroPrenotazione +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", utente=" + utente +
                ", veicolo=" + veicolo +
                '}';
    }
}