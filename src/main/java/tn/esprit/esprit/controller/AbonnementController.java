package tn.esprit.esprit.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprit.ServiceInterfaces.IAbonnementService;
import tn.esprit.esprit.entities.Abonnement;
import tn.esprit.esprit.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@RestController
@AllArgsConstructor
@RequestMapping("/abonnement")
@CrossOrigin(origins = "http://localhost:4200")
public class AbonnementController {
    IAbonnementService abonnementService;
@GetMapping("/getSubscriptionByType/{type}")
    public Set<Abonnement> getSubscriptionByType(@PathVariable("type") TypeAbonnement type) {
        return abonnementService.getSubscriptionByType(type);
    }
@GetMapping("/retrieveSubscriptionsByDates/{startDate}/{endDate}")
    public List<Abonnement> retrieveSubscriptionsByDates(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("startDate")
            LocalDate startDate,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)     @PathVariable("endDate") LocalDate endDate) {
        return abonnementService.retrieveSubscriptionsByDates(startDate, endDate);
    }
}
