package tn.esprit.esprit.ServiceInterfaces;

import tn.esprit.esprit.entities.Piste;
import tn.esprit.esprit.entities.Skieur;

import java.util.List;

public interface IPisteService {
    List<Piste> retrieveAllPistes();
    Piste addOrUpdatePiste(Piste piste);
    void removePiste (Piste piste);
    Piste retrievePiste (Long idPiste);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur disableSkierPiste(Long numSkieur, Long numPiste);

}
