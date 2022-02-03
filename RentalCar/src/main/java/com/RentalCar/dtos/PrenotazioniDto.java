package com.RentalCar.dtos;

import java.util.Date;

public class PrenotazioniDto {

    public PrenotazioniDto(int numeroPrenotazione, Date dataInizio, Date dataFine, Boolean approvazione) {
        this.numeroPrenotazione = numeroPrenotazione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.approvazione = approvazione;
    }

    public PrenotazioniDto() {
    }

    private int numeroPrenotazione;
    private Date dataInizio;
    private Date dataFine;
    private Boolean approvazione;

    public int getNumeroPrenotazione() {
        return numeroPrenotazione;
    }

    public void setNumeroPrenotazione(int numeroPrenotazione) {
        this.numeroPrenotazione = numeroPrenotazione;
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
}
