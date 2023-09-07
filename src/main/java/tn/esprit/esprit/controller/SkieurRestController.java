package tn.esprit.esprit.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprit.ServiceInterfaces.ISkieurService;
import tn.esprit.esprit.entities.Skieur;
import tn.esprit.esprit.entities.TypeAbonnement;

import java.util.List;

@RestController
@RequestMapping("/Skieur")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class SkieurRestController {
    ISkieurService skieurService;


@GetMapping("/getAllSkieur")
    public List<Skieur> retrieveAllSkieurs() {
        return skieurService.retrieveAllSkieurs();
    }
@PostMapping("/AddOrUpdate")
    public Skieur addOrUpdateSkieur(@RequestBody Skieur skieur) {
        return skieurService.addOrUpdateSkieur(skieur);
    }
@DeleteMapping("/delete")
    public void removeSkieur(@RequestBody Skieur skieur) {
        skieurService.removeSkieur(skieur);
    }
    @DeleteMapping("/deleteById/{idSkieur}")
    public void removeSkieurById(@PathVariable("idSkieur") Long idSkieur) {
        skieurService.removeSkieurById(idSkieur);
    }
    @GetMapping("/getById/{idSkieur}")
    public Skieur retrieveSkieur(@PathVariable("idSkieur") Long numSkieur) {
        return skieurService.retrieveSkieur(numSkieur);
    }

@PostMapping("/addSkierAndAssignToCourse/{numCours}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur
, @PathVariable("numCours") Long numCours) {
        return skieurService.addSkierAndAssignToCourse(skieur , numCours);
    }
@GetMapping("/retrieveSkiersBySubscriptionType/{type}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable("type") TypeAbonnement typeAbonnement) {
        return skieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
}
