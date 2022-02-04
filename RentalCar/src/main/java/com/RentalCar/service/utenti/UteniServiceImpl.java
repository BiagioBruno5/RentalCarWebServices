package com.RentalCar.service.utenti;

import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.dao.userDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UteniServiceImpl implements UtentiService {

    @Autowired
    private userDAO user;

    @Override
    public Boolean saveUser(Utente cust) {
        return user.saveUser(cust);
    }

    @Override
    public Boolean removeUserWithId(int id) {
        return user.removeUserWithId(id);
    }

    @Override
    public Boolean modificationUser(Utente customer) {
        return user.modificationUser(customer);
    }

    @Override
    public UtentiDto getUserById(int id) {

        Utente utente = user.getUserById(id);

        UtentiDto utenteDto = new UtentiDto(utente.getId(),
                utente.getNome(),
                utente.getCognome(),
                utente.getDataNascita(),
                utente.getIsSuperUser(),
                utente.getPassword());

        return utenteDto;
    }

    @Override
    public List<UtentiDto> getUser() {
        List<Utente> utenti = user.getUser();

        List<UtentiDto> utentiDto = new ArrayList<>();
        for (Utente utente : utenti) {
            utentiDto.add(new UtentiDto(
                    utente.getId(),
                    utente.getNome(),
                    utente.getCognome(),
                    utente.getDataNascita(),
                    utente.getIsSuperUser(),
                    utente.getPassword()));
        }

        return utentiDto;
    }

    @Override
    public Utente getUserByName(String nome) {
        return user.getUserByName(nome);
    }

    @Override
    public Utente getUserForLogin(String nome, String password) {
        return user.getUserForLogin(nome, password);
    }
}

/*
@Autowired
private  ModelMapper modelMapper;

List<UtentiDto> utentiDto = utenti
                .stream()
                .map(source -> modelMapper.map(source, UtentiDto.class))
                .collect(Collectors.toList());
*/