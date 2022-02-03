package com.RentalCar.dtos;

public class VeicoloDto {

    public VeicoloDto(int numeroTelaio, String targa, String casaCostruttrice, String modello, String tipologia) {
        this.numeroTelaio = numeroTelaio;
        this.targa = targa;
        this.casaCostruttrice = casaCostruttrice;
        this.modello = modello;
        this.tipologia = tipologia;
    }

    public VeicoloDto() {
    }

    private int numeroTelaio;
    private String targa;
    private String casaCostruttrice;
    private String modello;
    private String tipologia;

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
}
