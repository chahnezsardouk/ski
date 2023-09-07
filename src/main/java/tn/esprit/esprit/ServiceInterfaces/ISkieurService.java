package tn.esprit.esprit.ServiceInterfaces;

import tn.esprit.esprit.entities.Skieur;
import tn.esprit.esprit.entities.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addOrUpdateSkieur(Skieur skieur);
    void removeSkieur (Skieur skieur);
    void removeSkieurById (Long idSkieur);
    Skieur retrieveSkieur (Long numSkieur);
    Skieur addSkierAndAssignToCourse(Skieur skieur , Long numCours);

    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);


}
