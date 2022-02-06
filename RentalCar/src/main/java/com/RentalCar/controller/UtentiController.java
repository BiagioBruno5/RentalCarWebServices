package com.RentalCar.controller;

import com.RentalCar.dtos.GetClientDataDto;
import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.dtos.loginDataDto;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.bean.Veicolo;
import com.RentalCar.model.dao.userDAO;
import com.RentalCar.service.utenti.UtentiService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/utenti")
public class UtentiController {

    @Autowired
    UtentiService userDao;

    @Autowired
    userDAO utentiDDD;

    @GetMapping(value = "/lista", produces = "application/json")
    public @ResponseBody ResponseEntity<List<UtentiDto>> listaClienti(){

        System.out.println("**** OTTENIAMO LA LISTA DI UTENTI ****");

        List<UtentiDto> utenti = userDao.getUser();

        if(utenti == null){
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<List<UtentiDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<UtentiDto>>(utenti, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/cliente", produces = "application/json")
    public @ResponseBody ResponseEntity<UtentiDto> singoloCliente(@RequestBody GetClientDataDto idJson){
        System.out.println("**** OTTENIAMO IL SINGOLO UTENTE ****");

        System.out.println(idJson.getId());

        UtentiDto utente = userDao.getUserById(idJson.getId());
        System.out.println(utente.getNome());

        if(utente == null){
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<UtentiDto>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<UtentiDto>(utente, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/elimina", produces = "application/json")
    public @ResponseBody ResponseEntity<List<UtentiDto>> eliminaClienteTramiteId(@RequestBody GetClientDataDto idJson) {
        System.out.println("**** ELIMINAZIONE UTENTE TRAMITE ID ****");

        userDao.removeUserWithId(idJson.getId());

        System.out.println("**** OTTENIAMO LA LISTA DI UTENTI ****");

        List<UtentiDto> utenti = userDao.getUser();

        if (utenti == null) {
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);
            return new ResponseEntity<List<UtentiDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<UtentiDto>>(utenti, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/login", produces = "application/json")
    public @ResponseBody ResponseEntity<UtentiDto> loginCliente(@RequestBody loginDataDto utenteDto) {
        System.out.println("**** OTTENIAMO IL SINGOLO UTENTE ****");
        System.out.println(utenteDto.getUsername());

        //UtentiDto utente = userDao.getUserForLogin(utenteDto.getUsername(), utenteDto.getPassword());
        UtentiDto utente = userDao.getUserByName(utenteDto.getUsername());

        if(utente == null){
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<UtentiDto>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<UtentiDto>(utente, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/inserimento", produces = "application/json")
    public @ResponseBody ResponseEntity<List<UtentiDto>> inserisciCliente(@RequestBody UtentiDto utenteDto) {
        System.out.println("**** INSERIMENTO UTENTE ****");

        System.out.println(utenteDto.getNome());

        Utente utenteDaInserire = new Utente();
        utenteDaInserire.setNome(utenteDto.getNome());
        utenteDaInserire.setCognome(utenteDto.getCognome());
        utenteDaInserire.setDataNascita(utenteDto.getDataNascita());
        utenteDaInserire.setPassword(utenteDto.getPassword());

        userDao.saveUser(utenteDaInserire);

        System.out.println("**** OTTENIAMO LA LISTA DI UTENTI ****");

        List<UtentiDto> utenti = userDao.getUser();

        if (utenti == null) {
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);
            return new ResponseEntity<List<UtentiDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<UtentiDto>>(utenti, HttpStatus.OK);
        }
    }


    @PostMapping(value = "/modifica", produces = "application/json")
    public @ResponseBody ResponseEntity<List<UtentiDto>> modificaCliente(@RequestBody UtentiDto utenteDto) {
        System.out.println("**** MODIFICA UTENTE ****");

        System.out.println(utenteDto.getNome());
        System.out.println(utenteDto.getId());

        Utente utenteDaModificare = utentiDDD.getUserById(utenteDto.getId());
        utenteDaModificare.setNome(utenteDto.getNome());
        utenteDaModificare.setCognome(utenteDto.getCognome());
        utenteDaModificare.setDataNascita(utenteDto.getDataNascita());
        utenteDaModificare.setPassword(utenteDto.getPassword());

        //userDao.saveUser(utenteDaInserire);
        userDao.modificationUser(utenteDaModificare);

        System.out.println("**** OTTENIAMO LA LISTA DI UTENTI ****");

        List<UtentiDto> utenti = userDao.getUser();

        if (utenti == null) {
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);
            return new ResponseEntity<List<UtentiDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<UtentiDto>>(utenti, HttpStatus.OK);
        }
    }


}