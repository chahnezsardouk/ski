package tn.esprit.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprit.entities.Moniteur;
@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur,Long> {
}
