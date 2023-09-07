package tn.esprit.esprit.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprit.ServiceInterfaces.ICoursService;
import tn.esprit.esprit.entities.Cours;
import tn.esprit.esprit.entities.Inscription;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Gestion Cours")
@RestController
@AllArgsConstructor
@RequestMapping("/cours")
public class CoursRestController {
    ICoursService coursService;

    @Operation(description = "Cette méthode permet d'afficher les cours")


    @GetMapping("/getAll")
    public List<Cours> retrieveAllCourses() {

        return coursService.retrieveAllCourses();
    }


    @PostMapping("/addOrUpdate")
    public Cours addOrUpdateCours(@RequestBody Cours cours) {

        return coursService.addOrUpdateCours(cours);
    }

    @DeleteMapping("/remove-cours/{cours-id}")
    public void removeCours(@PathVariable("cours-id") Cours cours) {
        coursService.removeCours(cours);
    }

    @GetMapping("/findOne/{num}")
    public Cours retrieveCours(@PathVariable("num") Long numCours) {
        return coursService.retrieveCours(numCours);
    }

    @PutMapping("/Put")
    public Cours Put(@RequestBody Cours cours) {
        Cours rPut = coursService.addOrUpdateCours(cours);
        return rPut;
    }

    @PatchMapping(path ="/Patch")
    public Cours Patch(@RequestBody Cours cours) {
        Cours rPatch = coursService.addOrUpdateCours(cours);
        return rPatch;
    }
}


