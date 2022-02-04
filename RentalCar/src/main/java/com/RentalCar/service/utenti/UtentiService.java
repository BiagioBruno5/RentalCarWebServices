package com.RentalCar.service.utenti;

import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.model.bean.Utente;

import java.util.List;

public interface UtentiService {

    public Boolean saveUser(Utente cust);

    public Boolean removeUserWithId(int id);

    public Boolean modificationUser(Utente customer);

    public UtentiDto getUserById(int id);

    public List<UtentiDto> getUser();

    public UtentiDto getUserByName(String nome);

    public UtentiDto getUserForLogin(String nome, String password);
}
