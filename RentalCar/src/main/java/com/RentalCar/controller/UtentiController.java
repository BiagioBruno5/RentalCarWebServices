package com.RentalCar.controller;

import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.dao.userDAO;
import com.RentalCar.service.utenti.UtentiService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}