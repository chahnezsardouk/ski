package tn.esprit.esprit.ServiceImpl;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.esprit.Repository.AbonnementRepository;
import tn.esprit.esprit.Repository.SkieurRepository;
import tn.esprit.esprit.ServiceInterfaces.IAbonnementService;
import tn.esprit.esprit.entities.Abonnement;
import tn.esprit.esprit.entities.Skieur;
import tn.esprit.esprit.entities.TypeAbonnement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class AbonnementImpl implements IAbonnementService {
    AbonnementRepository abonnementRepository;
    SkieurRepository skieurRepository;
    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return abonnementRepository.findByTypeAbonOrderByStartDateAsc(type);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findByDateDebutBetween(startDate , endDate);
    }

    @Override
   // @Scheduled(cron = "*/30 * * * * *") /* Cron expression to run a job every 30 secondes */
    public void retrieveSubscriptions() {
        for (Abonnement abonnement: abonnementRepository.findDistinctOrderByEndDateAsc()) {
            Skieur askieur = skieurRepository.findByAbonnement(abonnement);
            long differenceInDays = ChronoUnit.DAYS.between(LocalDate.now(),
                    abonnement.getDateFin());
            System.out.println(differenceInDays);
            if(differenceInDays <= 7 ) {
            log.info(abonnement.getNumAbon().toString() + " | "+ abonnement.getDateFin().toString()
                    + " | "+ askieur.getNomS() + " " + askieur.getPrenomS());}
        }
    }


    // @Scheduled(cron = "* 0 9 1 * *") /* Cron expression to run a job every month at 9am */
   // @Scheduled(cron = "*/30 * * * * *") /* Cron expression to run a job every 30 secondes */
    public void showMonthlyRecurringRevenue() {
        Float revenue = abonnementRepository.revenueByTypeAbonnementEquals(TypeAbonnement.MENSUEL)
                + abonnementRepository.revenueByTypeAbonnementEquals(TypeAbonnement.SEMESTRIEL)/6
                + abonnementRepository.revenueByTypeAbonnementEquals(TypeAbonnement.ANNUEL)/12;
        log.info("Monthly Revenue = " + revenue);
    }
}

