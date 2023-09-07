package tn.esprit.esprit.ServiceInterfaces;

import org.springframework.stereotype.Service;
import tn.esprit.esprit.entities.Abonnement;
import tn.esprit.esprit.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public interface IAbonnementService {
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);

    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate,
                                                  LocalDate endDate);
    void retrieveSubscriptions();

}
