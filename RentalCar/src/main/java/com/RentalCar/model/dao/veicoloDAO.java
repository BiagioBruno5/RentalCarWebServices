package com.RentalCar.model.dao;

import com.RentalCar.model.bean.Veicolo;

import java.util.List;

public interface veicoloDAO {

    Boolean saveVeicolo(Veicolo veicolo);

    Boolean removeVeicoloWithId(int id);

    Boolean modificationVeicolo(Veicolo veicolo);

    List<Veicolo> getListaVeicoli();

    Veicolo getVeicoloByTelaio(int id);
}
