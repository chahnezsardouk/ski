package tn.esprit.esprit.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.esprit.Repository.CoursRepository;
import tn.esprit.esprit.Repository.InscriptionRepository;
import tn.esprit.esprit.Repository.SkieurRepository;
import tn.esprit.esprit.ServiceInterfaces.ISkieurService;
import tn.esprit.esprit.entities.Cours;
import tn.esprit.esprit.entities.Inscription;
import tn.esprit.esprit.entities.Skieur;
import tn.esprit.esprit.entities.TypeAbonnement;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkieurService implements ISkieurService {
    SkieurRepository skieurRepository;
    CoursRepository coursRepository;
    InscriptionRepository inscriptionRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addOrUpdateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Skieur skieur) {
        skieurRepository.delete(skieur);
    }

    @Override
    public void removeSkieurById(Long idSkieur) {
        skieurRepository.deleteById(idSkieur);

    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }


    @Transactional
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {

        Cours cours = coursRepository.findById(numCourse).orElse(null);

        Skieur savedSkier = skieurRepository.save(skieur);

        Set<Inscription> inscriptions = savedSkier.getInscriptions();
        for (Inscription inscription : inscriptions) {
            inscription.setSkieur(savedSkier);
            inscription.setCours(cours);
            inscriptionRepository.save(inscription);
        }
        return savedSkier;

    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return  skieurRepository.findByAbonnement_TypeAbon(typeAbonnement);
    }
}

//{
//
//        "nomS": "string",
//        "prenomS": "string",
//        "dateNaissance": "2023-03-08",
//        "ville": "string",
//        "inscriptions": [
//        {
//
//        "numSemaine": 0,
//        "cours": {
//        "numCours": 1
//
//        }
//        }
//        ]
//        }
