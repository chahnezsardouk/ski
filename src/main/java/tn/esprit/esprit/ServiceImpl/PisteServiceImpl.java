package tn.esprit.esprit.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprit.Repository.PisteRepository;
import tn.esprit.esprit.Repository.SkieurRepository;
import tn.esprit.esprit.ServiceInterfaces.IPisteService;
import tn.esprit.esprit.entities.Piste;
import tn.esprit.esprit.entities.Skieur;

import java.util.List;

@Service
@AllArgsConstructor
public class PisteServiceImpl implements IPisteService {

   // @Autowired
    PisteRepository pisteRepository;
    SkieurRepository skieurRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addOrUpdatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public void removePiste(Piste piste) {
        pisteRepository.delete(piste);

    }

    @Override
    public Piste retrievePiste(Long idPiste) {
        return pisteRepository.findById(idPiste).orElse(null);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);


        piste.getSkieurs().add(skieur);
        pisteRepository.save(piste);
        return skieur;
    }

    @Override
    public Skieur disableSkierPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        piste.getSkieurs().remove(skieur);
        pisteRepository.save(piste);

        return skieur;
    }
}
