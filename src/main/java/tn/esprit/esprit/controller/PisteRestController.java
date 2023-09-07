package tn.esprit.esprit.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprit.ServiceInterfaces.IPisteService;
import tn.esprit.esprit.entities.Piste;
import tn.esprit.esprit.entities.Skieur;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Piste")
public class PisteRestController {

    //@Autowired
    IPisteService pisteService;

    @GetMapping("/getAll")
    public List<Piste> retrieveAllPistes() {
        return pisteService.retrieveAllPistes();
    }
@PostMapping("/addPiste")
    public Piste addOrUpdatePiste(@RequestBody Piste piste) {
        return pisteService.addOrUpdatePiste(piste);
    }
@DeleteMapping("/delete")
    public void removePiste(@RequestBody Piste piste) {
        pisteService.removePiste(piste);
    }

    @GetMapping("/findById/{idPi}")
    public Piste retrievePiste(@PathVariable("idPi") Long idPiste) {
        return pisteService.retrievePiste(idPiste);
    }

    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable("numSkieur") Long numSkieur,
                                     @PathVariable("numPiste") Long numPiste) {
        return pisteService.assignSkierToPiste(numSkieur, numPiste);
    }
    @PutMapping("/disableSkierPiste/{numSkieur}/{numPiste}")
    public Skieur disableSkierPiste(@PathVariable("numSkieur") Long numSkieur,
                                    @PathVariable("numPiste") Long numPiste){
        return pisteService.disableSkierPiste(numSkieur, numPiste);
    }
}
