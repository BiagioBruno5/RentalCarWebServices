package com.RentalCar.controller;

import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.dtos.VeicoloDto;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.bean.Veicolo;
import com.RentalCar.service.veicoli.VeicoliService;
import com.RentalCar.service.veicoli.VeicoliServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/veicoli")
public class VeicoliController {

    @Autowired
    VeicoliService veicoliService;

    @GetMapping(value = "/lista", produces = "application/json")
    public @ResponseBody ResponseEntity<List<VeicoloDto>> listaVeicoli(){

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

    @GetMapping(value = "/veicolo/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<VeicoloDto> singoloVeicolo(@PathVariable("id") int id){

        System.out.println("**** OTTENIAMO IL SINGOLO VEICOLO ****");

        VeicoloDto veicolo = veicoliService.getVeicoloByTelaio(id);

        if(veicolo == null){
            String messaggioDiErrore = "veicolo non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<VeicoloDto>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<VeicoloDto>(veicolo, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/elimina/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<List<VeicoloDto>> eliminaVeicoloTramiteId(@PathVariable("id") int id) {

        System.out.println("**** ELIMINAZIONE VEICOLO TRAMITE ID ****");

        veicoliService.removeVeicoloWithId(id);

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

    @PostMapping(value = "/inserimento", produces = "application/json")
    public @ResponseBody ResponseEntity<List<VeicoloDto>> inserisciVeicolo(@RequestBody VeicoloDto veicoloDto) {
        System.out.println("**** INSERIMENTO VEICOLO ****");

        Veicolo veicoloDaInserire = new Veicolo();

        veicoloDaInserire.setNumeroTelaio(veicoloDto.getNumeroTelaio());
        veicoloDaInserire.setCasaCostruttrice(veicoloDto.getCasaCostruttrice());
        veicoloDaInserire.setModello(veicoloDto.getModello());
        veicoloDaInserire.setTarga(veicoloDto.getTarga());
        veicoloDaInserire.setTipologia(veicoloDto.getTipologia());

        veicoliService.saveVeicolo(veicoloDaInserire);

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
