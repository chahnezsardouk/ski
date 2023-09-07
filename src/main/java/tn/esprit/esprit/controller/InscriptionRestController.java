package tn.esprit.esprit.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprit.ServiceInterfaces.IInscriptionService;
import tn.esprit.esprit.entities.Inscription;

@RestController
@RequestMapping("/Inscription")
@AllArgsConstructor
public class InscriptionRestController {

    @PostMapping("/addReAngAssign/{numSki}")
    public Inscription addRegistrationAndAssignToSkier(
           @RequestBody Inscription registration,
           @PathVariable("numSki") Long numSkier) {
        return inscriptionService.addRegistrationAndAssignToSkier(registration, numSkier);
    }

    IInscriptionService inscriptionService;

@PutMapping("/assignRegistrationToCourse/{numR}/{numC}")
    public Inscription assignRegistrationToCourse(@PathVariable("numR") Long numRegistration,
                                                  @PathVariable("numC") Long numCourse) {
        return inscriptionService.assignRegistrationToCourse(numRegistration, numCourse);
    }
    @PutMapping("/disableRegistrationCourse/{numR}/{numC}")
    public Inscription disableRegistrationCourse(@PathVariable("numR") Long numRegistration,
                                                 @PathVariable("numC") Long numCourse){
        return inscriptionService.disableRegistrationCourse(numRegistration, numCourse);
    }

    @PostMapping("/addRegistrationAndAssignToSkierAndCourse/{numSkieur}/{numCours}")
    public Inscription addRegistrationAndAssignToSkierAndCourse(
            @RequestBody Inscription inscription,
            @PathVariable("numSkieur") Long numSkieur,
            @PathVariable("numCours") Long numCours) {
        return inscriptionService.addRegistrationAndAssignToSkierAndCourse(inscription, numSkieur, numCours);
    }
}
