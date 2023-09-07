package tn.esprit.esprit.ServiceInterfaces;

import tn.esprit.esprit.entities.Inscription;

public interface IInscriptionService {
    Inscription addRegistrationAndAssignToSkier(Inscription registration, Long numSkier);

    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Inscription disableRegistrationCourse(Long numRegistration, Long numCourse);
    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription,
                                                         Long numSkieur, Long numCours);

}
