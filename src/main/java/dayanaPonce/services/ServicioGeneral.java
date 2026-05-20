package dayanaPonce.services;

import dayanaPonce.models.*;
import dayanaPonce.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ServicioGeneral {

    private final ObraRepository obraRespo;
    private final ExposicionRepository exposicionRespo;

    public ServicioGeneral(ObraRepository obraRespo, ExposicionRepository exposicionRespo) {
        this.obraRespo = obraRespo;
        this.exposicionRespo = exposicionRespo;
    }

    //PARA OBRASS
    
}