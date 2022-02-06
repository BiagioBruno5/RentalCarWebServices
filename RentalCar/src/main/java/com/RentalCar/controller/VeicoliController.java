package com.RentalCar.controller;

import com.RentalCar.dtos.GetClientDataDto;
import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.dtos.VeicoloDto;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.bean.Veicolo;
import com.RentalCar.model.dao.veicoloDAO;
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

    @Autowired
    veicoloDAO veicDao;

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

    @PostMapping(value = "/veicolo", produces = "application/json")
    public @ResponseBody ResponseEntity<VeicoloDto> singoloVeicolo(@RequestBody GetClientDataDto idJson){

        System.out.println("**** OTTENIAMO IL SINGOLO VEICOLO ****");

        VeicoloDto veicolo = veicoliService.getVeicoloByTelaio(idJson.getId());

        if(veicolo == null){
            String messaggioDiErrore = "veicolo non trovata";
            System.out.println(messaggioDiErrore);

            return new ResponseEntity<VeicoloDto>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<VeicoloDto>(veicolo, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/elimina", produces = "application/json")
    public @ResponseBody ResponseEntity<List<VeicoloDto>> eliminaVeicoloTramiteId(@RequestBody GetClientDataDto idJson) {

        System.out.println("**** ELIMINAZIONE VEICOLO TRAMITE ID ****");

        veicoliService.removeVeicoloWithId(idJson.getId());

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

        System.out.println(veicoloDto.getCasaCostruttrice());

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


    @PostMapping(value = "/modifica", produces = "application/json")
    public @ResponseBody ResponseEntity<List<VeicoloDto>> modificaVeicolo(@RequestBody VeicoloDto veicoloDto) {
        System.out.println("**** MODIFICA VEICOLO ****");


        Veicolo veicoloDaModificare = veicDao.getVeicoloByTelaio(veicoloDto.getNumeroTelaio());
        veicoloDaModificare.setTarga(veicoloDto.getTarga());
        veicoloDaModificare.setCasaCostruttrice(veicoloDto.getCasaCostruttrice());
        veicoloDaModificare.setModello(veicoloDto.getModello());
        veicoloDaModificare.setTipologia(veicoloDto.getTipologia());

        veicDao.modificationVeicolo(veicoloDaModificare);

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
