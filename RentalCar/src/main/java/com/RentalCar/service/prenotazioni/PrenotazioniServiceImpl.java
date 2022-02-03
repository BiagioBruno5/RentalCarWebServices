package com.RentalCar.service.prenotazioni;

import com.RentalCar.dtos.PrenotazioniDto;
import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.model.bean.Prenotazioni;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.dao.prenotazioniDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrenotazioniServiceImpl implements PrenotazioniService{

    @Autowired
    private prenotazioniDAO pren;

    @Override
    public Boolean savePrenotazioni(Prenotazioni prenotazioni) {
        return pren.savePrenotazioni(prenotazioni);
    }

    @Override
    public Boolean removePrenotazioniWithId(int id) {
        return pren.removePrenotazioniWithId(id);
    }

    @Override
    public Boolean modificationPrenotazioni(Prenotazioni prenotazioni) {
        return pren.modificationPrenotazioni(prenotazioni);
    }

    @Override
    public Prenotazioni getPrenotazioneByNumeroPrenotazione(int id) {
        return pren.getPrenotazioneByNumeroPrenotazione(id);
    }

    @Override
    public List<PrenotazioniDto> getListaPrenotazioniById(int id_user) {

        List<Prenotazioni> prenotazioni = pren.getListaPrenotazioniById(id_user);

        List<PrenotazioniDto> prenotazioniDto = new ArrayList<>();

        for (Prenotazioni pren : prenotazioni) {
            prenotazioniDto.add(new PrenotazioniDto(
                    pren.getNumeroPrenotazione(),
                    pren.getDataInizio(),
                    pren.getDataFine(),
                    pren.getApprovazione()
            ));
        }

        return prenotazioniDto;
    }

    @Override
    public List<PrenotazioniDto> getListaPrenotazioni() {
        List<Prenotazioni> prenotazioni = pren.getListaPrenotazioni();

        List<PrenotazioniDto> prenotazioniDto = new ArrayList<>();

        for (Prenotazioni pren : prenotazioni) {
            prenotazioniDto.add(new PrenotazioniDto(
                    pren.getNumeroPrenotazione(),
                    pren.getDataInizio(),
                    pren.getDataFine(),
                    pren.getApprovazione()
            ));
        }

        return prenotazioniDto;
    }
}
