package com.RentalCar.controller;

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

    @GetMapping(value = "/cliente/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<UtentiDto> singoloCliente(@PathVariable("id") int id){

        System.out.println("**** OTTENIAMO IL SINGOLO UTENTE ****");

        UtentiDto utente = userDao.getUserById(id);

        if(utente == null){
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<UtentiDto>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<UtentiDto>(utente, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/login", produces = "application/json")
    public @ResponseBody ResponseEntity<UtentiDto> loginCliente(@RequestBody loginDataDto utenteDto) {

        System.out.println("**** OTTENIAMO IL SINGOLO UTENTE ****");

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

    @GetMapping(value = "/elimina/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<List<UtentiDto>> eliminaClienteTramiteId(@PathVariable("id") int id) {

        System.out.println("**** ELIMINAZIONE UTENTE TRAMITE ID ****");

        userDao.removeUserWithId(id);

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

    @PostMapping(value = "/inserimento", produces = "application/json")
    public @ResponseBody ResponseEntity<List<UtentiDto>> inserisciCliente(@RequestBody UtentiDto utenteDto) {
        System.out.println("**** INSERIMENTO UTENTE ****");

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


}