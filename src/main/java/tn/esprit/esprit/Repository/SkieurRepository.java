package tn.esprit.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprit.entities.Abonnement;
import tn.esprit.esprit.entities.Piste;
import tn.esprit.esprit.entities.Skieur;
import tn.esprit.esprit.entities.TypeAbonnement;

import java.util.List;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur,Long> {
    //Récupérer la liste des skieur by piste
     List<Skieur> findByPistesNumPiste(Long num);

     List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);


    Skieur findByAbonnement(Abonnement abonnement);

}
