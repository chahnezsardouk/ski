package tn.esprit.esprit.ServiceInterfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.esprit.entities.Cours;
import tn.esprit.esprit.entities.Inscription;

import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCourses();
    Cours addOrUpdateCours(Cours cours);
    void removeCours (Cours cours);
    Cours retrieveCours (Long numCours);
}
