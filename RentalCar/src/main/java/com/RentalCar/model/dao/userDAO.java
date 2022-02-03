package com.RentalCar.model.dao;

import com.RentalCar.model.bean.Utente;

import java.util.List;

public interface userDAO {

    Boolean saveUser(Utente cust);

    Boolean removeUserWithId(int id);

    Boolean modificationUser(Utente customer);

    Utente getUserById(int id);

    List<Utente> getUser();

    Utente getUserForLogin(String nome, String password);

    Utente getUserByName(String nome);
}
