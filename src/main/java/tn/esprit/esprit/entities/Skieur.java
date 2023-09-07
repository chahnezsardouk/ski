package tn.esprit.esprit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;

    @ToString.Exclude
    //@JsonIgnore
    //remarque new
    @OneToMany(mappedBy = "skieur" , cascade = CascadeType.ALL)
    private Set<Inscription> inscriptions ;



    @ToString.Exclude
     @ManyToMany(mappedBy = "skieurs")
    @JsonIgnore
    private Set<Piste> pistes ;




    @ToString.Exclude
    //remarque

     @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;
}
