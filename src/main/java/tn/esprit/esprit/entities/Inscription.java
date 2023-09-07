package tn.esprit.esprit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInscription;
    private Integer numSemaine;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    Cours cours;
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    Skieur skieur;
}
