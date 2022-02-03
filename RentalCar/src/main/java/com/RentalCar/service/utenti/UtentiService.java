package com.RentalCar.service.utenti;

import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.model.bean.Utente;

import java.util.List;

public interface UtentiService {

    public Boolean saveUser(Utente cust);

    public Boolean removeUserWithId(int id);

    public Boolean modificationUser(Utente customer);

    public Utente getUserById(int id);

    public List<UtentiDto> getUser();

    public Utente getUserByName(String nome);

    public Utente getUserForLogin(String nome, String password);
}
