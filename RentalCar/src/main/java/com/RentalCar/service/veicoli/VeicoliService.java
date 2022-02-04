package com.RentalCar.service.veicoli;

import com.RentalCar.dtos.VeicoloDto;
import com.RentalCar.model.bean.Veicolo;

import java.util.List;

public interface VeicoliService {

    Boolean saveVeicolo(Veicolo veicolo);

    Boolean removeVeicoloWithId(int id);

    Boolean modificationVeicolo(Veicolo veicolo);

    List<VeicoloDto> getListaVeicoli();

    VeicoloDto getVeicoloByTelaio(int id);

}
