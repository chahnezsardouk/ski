package tn.esprit.esprit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String nomPiste;
    @Enumerated(EnumType.STRING)
    private Color couleur;
    private Integer longeur;
    private Integer pente;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany
    private Set<Skieur> skieurs;

}
