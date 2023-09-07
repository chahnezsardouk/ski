package tn.esprit.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.esprit.entities.Abonnement;
import tn.esprit.esprit.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {

    Set<Abonnement> findByTypeAbonOrderByDateDebutAsc(TypeAbonnement typeAbonnement);


    @Query("select abonnement from Abonnement abonnement where abonnement.typeAbon = :typeAbonnement order by abonnement.dateDebut")
    Set<Abonnement> findByTypeAbonOrderByStartDateAsc(@Param("typeAbonnement") TypeAbonnement typeAbonnement);




    List<Abonnement> findByDateDebutBetween(LocalDate dateDebut, LocalDate Datefin);

    @Query("select distinct abonnement from Abonnement abonnement where abonnement.dateFin >= CURRENT_TIME order by abonnement.dateFin")
    List<Abonnement> findDistinctOrderByEndDateAsc();


    @Query("select (sum(abonnement.prixAbon))/(count(abonnement)) " +
            "from Abonnement abonnement" +
            " where abonnement.typeAbon = ?1")
    Float revenueByTypeAbonnementEquals(TypeAbonnement typeAbonnement);




}
