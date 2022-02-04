package com.RentalCar.service.prenotazioni;

import com.RentalCar.dtos.PrenotazioniDto;
import com.RentalCar.model.bean.Prenotazioni;

import java.util.List;

public interface PrenotazioniService {

    Boolean savePrenotazioni(Prenotazioni prenotazioni);

    Boolean removePrenotazioniWithId(int id);

    Boolean modificationPrenotazioni(Prenotazioni prenotazioni);

    PrenotazioniDto getPrenotazioneByNumeroPrenotazione(int id);

    List<PrenotazioniDto> getListaPrenotazioni();

    List<PrenotazioniDto> getListaPrenotazioniById(int id_user);

}
