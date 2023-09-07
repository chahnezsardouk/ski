package tn.esprit.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprit.entities.Color;
import tn.esprit.esprit.entities.Piste;

import java.util.List;

@Repository
public interface PisteRepository extends JpaRepository<Piste,Long> {
       //Récupérer la liste des pistes d'un skieur
       List<Piste> findBySkieursNumSkieur(Long num);
       List<Piste> findBySkieursPrenomSLikeAndSkieursNumSkieur(String prenom, Long numSkieur);

       //Récupérer la liste des pistes par le nom d'un Skieur ainsi que le numéro d'inscription
       List<Piste> findBySkieursPrenomSLikeAndSkieursInscriptionsNumInscription(String prenom, Long numInscription);

//Récupérer la liste des pistes des Skieurs qui ont un nom "ABC"
       List<Piste> findBySkieursNomS(String nom);

       List<Piste> findBySkieursNumSkieurAndNumPiste(Long numSki, Long numPiste);


       List<Piste> findByNomPisteAndCouleur(String nom , Color couleur);

}
