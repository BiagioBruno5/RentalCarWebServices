package com.RentalCar.controller;
import com.RentalCar.dtos.PrenotazioniDto;
import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.service.prenotazioni.PrenotazioniServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioniService {

    @Autowired
    PrenotazioniServiceImpl prenotazioniService;

    @GetMapping(value = "/lista", produces = "application/json")
    public @ResponseBody ResponseEntity<List<PrenotazioniDto>> listaClienti(){

        System.out.println("**** OTTENIAMO LA LISTA DELLE PRENOTAZIONI ****");

        List<PrenotazioniDto> prenotazioni = prenotazioniService.getListaPrenotazioni();

        if(prenotazioni == null){
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<List<PrenotazioniDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<PrenotazioniDto>>(prenotazioni, HttpStatus.OK);
        }
    }


    @GetMapping(value = "/prenotazione/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<List<PrenotazioniDto>> listaClienti(@PathVariable("id") int id){

        System.out.println("**** OTTENIAMO LA PRENOTAZIONE ****");

        List<PrenotazioniDto> prenotazioni = prenotazioniService.getListaPrenotazioniById(id);

        if(prenotazioni == null){
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<List<PrenotazioniDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<PrenotazioniDto>>(prenotazioni, HttpStatus.OK);
        }
    }
}
