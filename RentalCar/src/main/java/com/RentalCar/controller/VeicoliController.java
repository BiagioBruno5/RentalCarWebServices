package com.RentalCar.controller;

import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.dtos.VeicoloDto;
import com.RentalCar.service.veicoli.VeicoliService;
import com.RentalCar.service.veicoli.VeicoliServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/veicoli")
public class VeicoliController {

    @Autowired
    VeicoliService veicoliService;

    @GetMapping(value = "/lista", produces = "application/json")
    public @ResponseBody
    ResponseEntity<List<VeicoloDto>> listaVeicoli(){

        System.out.println("**** OTTENIAMO LA LISTA DEI VEICOLI ****");

        List<VeicoloDto> veicoli = veicoliService.getListaVeicoli();

        if(veicoli == null){
            String messaggioDiErrore = "Lista utenti non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<List<VeicoloDto>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<VeicoloDto>>(veicoli, HttpStatus.OK);
        }
    }
}
