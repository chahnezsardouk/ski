package tn.esprit.esprit.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprit.ServiceInterfaces.IMoniteurService;
import tn.esprit.esprit.entities.Moniteur;

import java.util.List;

@RestController
@RequestMapping("/moniteur")
@AllArgsConstructor
public class MoniteurRestController {

    IMoniteurService moniteurService;

    @GetMapping("/getAllMoniteurs")
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurService.retrieveAllMoniteurs();
    }
@PostMapping("/addMoniteur")
    public Moniteur addOrUpdateMoniteur(Moniteur moniteur) {
        return moniteurService.addOrUpdateMoniteur(moniteur);
    }
@DeleteMapping("/deleteMoniteur")
    public void removeMoniteur(Moniteur moniteur) {
        moniteurService.removeMoniteur(moniteur);
    }
@GetMapping("/findByNum")
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurService.retrieveMoniteur(numMoniteur);
    }
@PostMapping("/addMoniteur/{numCours}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur, @PathVariable("numCours") Long numCourse) {
        return moniteurService.addInstructorAndAssignToCourse(moniteur, numCourse);
    }

}
