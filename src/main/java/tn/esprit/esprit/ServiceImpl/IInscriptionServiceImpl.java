package tn.esprit.esprit.ServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.esprit.Repository.CoursRepository;
import tn.esprit.esprit.Repository.InscriptionRepository;
import tn.esprit.esprit.Repository.SkieurRepository;
import tn.esprit.esprit.ServiceInterfaces.IInscriptionService;
import tn.esprit.esprit.entities.Cours;
import tn.esprit.esprit.entities.Inscription;
import tn.esprit.esprit.entities.Skieur;

import java.time.LocalDate;
import java.time.Period;
@Slf4j
@Service
@AllArgsConstructor
public class IInscriptionServiceImpl implements IInscriptionService {
    SkieurRepository skieurRepository;
    InscriptionRepository inscriptionRepository;
    CoursRepository coursRepository;

    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription registration, Long numSkier) {
        Skieur skieur = skieurRepository.findById(numSkier).orElse(null);
        registration.setSkieur(skieur);
        return inscriptionRepository.save(registration);

    }

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = inscriptionRepository.findById(numRegistration).orElse(null);
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        inscription.setCours(cours);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription disableRegistrationCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = inscriptionRepository.findById(numRegistration).orElse(null);
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        System.out.println(inscription);
        assert inscription != null;
        inscription.setCours(null);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(
            Inscription inscription, Long numSkieur, Long numCours) {
        Cours cours = coursRepository.findById(numCours).orElse(null);
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);

        if (skieur == null || cours == null) {
            return null;
        }

        if(inscriptionRepository.countDistinctByNumSemaineAndSkieurNumSkieurAndCoursNumCours(inscription.getNumSemaine(),
                skieur.getNumSkieur(), cours.getNumCours()) >=1){
            log.info("Sorry, you're already register to this course of the week :" + inscription.getNumSemaine());
            return null;
        }

        int ageSkieur = Period.between(skieur.getDateNaissance(), LocalDate.now()).getYears();
        log.info("Age " + ageSkieur);

        switch (cours.getTypeCours()) {
            case PARTICULIER:
                log.info("add without tests");
                return assignRegistration(inscription, skieur, cours);

            case COLLECTIF_ENFANT:
                if (ageSkieur < 16) {
                    log.info("Ok CHILD !");
                    if (inscriptionRepository.countByCoursAndNumSemaine(cours, inscription.getNumSemaine()) < 6) {
                        log.info("Course successfully added !");
                        return assignRegistration(inscription, skieur, cours);
                    } else {
                        log.info("Full Course ! Please choose another week to register !");
                        return null;
                    }
                }
                else{
                    log.info("Sorry, your age doesn't allow you to register for this course ! \n Try to Register to a Collective Adult Course...");
                }
                break;

            default:
                if (ageSkieur >= 16) {
                    log.info("Ok ADULT !");
                    if (inscriptionRepository.countByCoursAndNumSemaine(cours, inscription.getNumSemaine()) < 6) {
                        log.info("Course successfully added !");
                        return assignRegistration(inscription, skieur, cours);
                    } else {
                        log.info("Full Course ! Please choose another week to register !");
                        return null;
                    }
                }
                log.info("Sorry, your age doesn't allow you to register for this course ! \n Try to Register to a Collective Child Course...");
        }
        return inscription;

    }
    private Inscription assignRegistration (Inscription registration, Skieur skier, Cours course){
        registration.setSkieur(skier);
        registration.setCours(course);
        return inscriptionRepository.save(registration);
    }

}
