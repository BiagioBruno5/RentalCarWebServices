package com.RentalCar.model.dao;

import com.RentalCar.model.bean.Prenotazioni;

import java.util.List;

public interface prenotazioniDAO {

    Boolean savePrenotazioni(Prenotazioni prenotazioni);

    Boolean removePrenotazioniWithId(int id);

    Boolean modificationPrenotazioni(Prenotazioni prenotazioni);

    Prenotazioni getPrenotazioneByNumeroPrenotazione(int id);

    List<Prenotazioni> getListaPrenotazioniById(int id_user);
    
    List<Prenotazioni> getListaPrenotazioni();
}
