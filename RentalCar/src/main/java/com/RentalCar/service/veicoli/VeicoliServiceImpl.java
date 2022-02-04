package com.RentalCar.service.veicoli;

import com.RentalCar.dtos.UtentiDto;
import com.RentalCar.dtos.VeicoloDto;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.model.bean.Veicolo;
import com.RentalCar.model.dao.veicoloDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeicoliServiceImpl implements VeicoliService{

    @Autowired
    private veicoloDAO veic;

    @Override
    public Boolean saveVeicolo(Veicolo veicolo) {
        return veic.saveVeicolo(veicolo);
    }

    @Override
    public Boolean removeVeicoloWithId(int id) {
        return veic.removeVeicoloWithId(id);
    }

    @Override
    public Boolean modificationVeicolo(Veicolo veicolo) {
        return veic.modificationVeicolo(veicolo);
    }

    @Override
    public List<VeicoloDto> getListaVeicoli() {

        List<Veicolo> veicoli = veic.getListaVeicoli();
        List<VeicoloDto> veicoliDto = new ArrayList<>();

        for (Veicolo veicolo : veicoli) {
            veicoliDto.add(new VeicoloDto(
                    veicolo.getNumeroTelaio(),
                    veicolo.getTarga(),
                    veicolo.getCasaCostruttrice(),
                    veicolo.getModello(),
                    veicolo.getTipologia()));
        }

        return veicoliDto;
    }

    @Override
    public VeicoloDto getVeicoloByTelaio(int id) {
        Veicolo veicolo = veic.getVeicoloByTelaio(id);

        VeicoloDto veicoloDto = new VeicoloDto(
                veicolo.getNumeroTelaio(),
                veicolo.getTarga(),
                veicolo.getCasaCostruttrice(),
                veicolo.getModello(),
                veicolo.getTipologia());

        return veicoloDto;
    }
}
