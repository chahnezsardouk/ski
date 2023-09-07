package tn.esprit.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprit.entities.Cours;
import tn.esprit.esprit.entities.Inscription;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Long> {
//Récupérer le cours d'une inscription
Cours findByInscriptionsNumInscription(Long numInsciption);

}
