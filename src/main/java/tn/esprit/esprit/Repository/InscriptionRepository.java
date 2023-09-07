package tn.esprit.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.esprit.entities.Cours;
import tn.esprit.esprit.entities.Inscription;
import tn.esprit.esprit.entities.Support;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {

    //Récupérer la liste des inscriptions d'un cours
    List<Inscription> findByCoursNumCours(Long num);

//Calcul cours d'une semaine
    long countByCoursAndNumSemaine(Cours course, int numWeek);

    @Query("select count(distinct inscription) from Inscription inscription " +
            "where inscription.numSemaine = ?1" +
            "and inscription.skieur.numSkieur = ?2 " +
            "and inscription.cours.numCours = ?3")
    long countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(int numWeek,
                                                                    Long numSkier,
                                                                    Long numCourse);

      long countDistinctByNumSemaineAndSkieurNumSkieurAndCoursNumCours(int numWeek
              , Long numSkier,
                                                                       Long numCourse);

    @Query("select inscription.numSemaine from Inscription inscription " +
            "join Moniteur moniteur " +
            "on inscription.cours member moniteur.cours " +
            "where moniteur.numMoniteur = :idIns and inscription.cours.support = :support")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("idIns") Long numInstructor, @Param("support") Support support);



}
