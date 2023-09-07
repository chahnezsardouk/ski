package tn.esprit.esprit.ServiceInterfaces;

import tn.esprit.esprit.entities.Moniteur;

import java.util.List;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addOrUpdateMoniteur(Moniteur moniteur);
    void removeMoniteur (Moniteur moniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);
    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);


}
