package com.RentalCar.service;

import java.net.URI;
import java.net.URISyntaxException;

import com.RentalCar.config.security.UserConfig;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.dao.userDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    userDAO user;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {
        String ErrMsg = "";

        if (username == null || username.length() < 2)
        {
            ErrMsg = "Nome utente assente o non valido";

            logger.warn(ErrMsg);

            throw new UsernameNotFoundException(ErrMsg);
        }

        Utente utente = this.GetValue(username);

        if (utente == null)
        {
            ErrMsg = String.format("Utente %s non Trovato!!", username);

            logger.warn(ErrMsg);

            throw new UsernameNotFoundException(ErrMsg);
        }

        User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(utente.getNome());
        builder.password(utente.getPassword());

        String stringaAutorita;
        if(utente.is_SuperUser()){
            stringaAutorita = "ADMIN";
        }
        else{
            stringaAutorita = "CUSTOMER";
        }

        String[] autorita = {stringaAutorita};

        builder.authorities(autorita);

        return builder.build();


    }

    private Utente GetValue(String username)
    {
        Utente utente = null;

        try
        {
            utente = user.getUserByName(username);
            System.out.println(utente.getCognome() + " " + utente.getPassword());
        }
        catch (Exception e)
        {
            String ErrMsg = String.format("Connessione al servizio di autenticazione non riuscita!!");

            logger.warn(ErrMsg);
        }
        return utente;
    }
}