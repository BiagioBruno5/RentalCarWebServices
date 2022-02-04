package com.RentalCar.controller;
import com.RentalCar.dtos.PrenotazioniDto;
import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.model.bean.Prenotazioni;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.dao.prenotazioniDAO;
import com.RentalCar.model.dao.userDAO;
import com.RentalCar.model.dao.veicoloDAO;
import com.RentalCar.service.prenotazioni.PrenotazioniServiceImpl;
import com.RentalCar.service.utenti.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioniController {

    @Autowired
    PrenotazioniServiceImpl prenotazioniService;

    @Autowired
    prenotazioniDAO prenotazioniDao;

    @Autowired
    userDAO utentiDAO;

    @Autowired
    veicoloDAO veicoloDao;

    @GetMapping(value = "/lista", produces = "application/json")
    public @ResponseBody ResponseEntity<List<PrenotazioniDto>> listaPrenotazioni(){

        System.out.println("**** OTTENIAMO LA LISTA DELLE PRENOTAZIONI ****");

        List<PrenotazioniDto> prenotazioni = prenotazioniService.getListaPrenotazioni();

        if(prenotazioni == null){
            String messaggioDiErrore = "Lista prenotazioni non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<List<PrenotazioniDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<PrenotazioniDto>>(prenotazioni, HttpStatus.OK);
        }
    }


    @GetMapping(value = "/prenotazione/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<List<PrenotazioniDto>> singolaPrenotazione(@PathVariable("id") int id){

        System.out.println("**** OTTENIAMO LA PRENOTAZIONE ****");

        List<PrenotazioniDto> prenotazioni = prenotazioniService.getListaPrenotazioniById(id);

        if(prenotazioni == null){
            String messaggioDiErrore = "Prenotazione non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<List<PrenotazioniDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<PrenotazioniDto>>(prenotazioni, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/prenotazioneByNumeroPrenotazione/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<PrenotazioniDto> singolaPrenotazioneByNumeroPrenotazione(@PathVariable("id") int id){

        System.out.println("**** OTTENIAMO LA PRENOTAZIONE ****");

        PrenotazioniDto prenotazione = prenotazioniService.getPrenotazioneByNumeroPrenotazione(id);

        if(prenotazione == null){
            String messaggioDiErrore = "Prenotazione non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<PrenotazioniDto>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<PrenotazioniDto>(prenotazione, HttpStatus.OK);
        }
    }


    @GetMapping(value = "/elimina/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<List<PrenotazioniDto>> eliminaPrenotazioneTramiteId(@PathVariable("id") int id) {

        System.out.println("**** ELIMINAZIONE UTENTE TRAMITE ID ****");

        prenotazioniService.removePrenotazioniWithId(id);

        System.out.println("**** OTTENIAMO LA LISTA DELLE PRENOTAZIONI ****");

        List<PrenotazioniDto> prenotazioni = prenotazioniService.getListaPrenotazioni();

        if(prenotazioni == null){
            String messaggioDiErrore = "Lista prenotazioni non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<List<PrenotazioniDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<PrenotazioniDto>>(prenotazioni, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/inserimento", produces = "application/json")
    public @ResponseBody ResponseEntity<List<PrenotazioniDto>> inserisciCliente(@RequestBody PrenotazioniDto prenotazioniDto) {
        System.out.println("**** INSERIMENTO PRENOTAZIONE ****");

        Prenotazioni prenotazione = new Prenotazioni();

        prenotazione.setUtente(utentiDAO.getUserById(prenotazioniDto.getIdUtente()));
        prenotazione.setVeicolo(veicoloDao.getVeicoloByTelaio(prenotazioniDto.getIdVeicolo()));
        prenotazione.setNumeroPrenotazione(prenotazioniDto.getNumeroPrenotazione());
        prenotazione.setDataInizio(prenotazioniDto.getDataInizio());
        prenotazione.setDataFine(prenotazioniDto.getDataFine());
        prenotazione.setApprovazione(prenotazioniDto.getApprovazione());

        prenotazioniService.savePrenotazioni(prenotazione);

        System.out.println("**** OTTENIAMO LA LISTA DELLE PRENOTAZIONI ****");

        List<PrenotazioniDto> prenotazioni = prenotazioniService.getListaPrenotazioni();

        if(prenotazioni == null){
            String messaggioDiErrore = "Lista prenotazioni non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<List<PrenotazioniDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<PrenotazioniDto>>(prenotazioni, HttpStatus.OK);
        }
    }
}
