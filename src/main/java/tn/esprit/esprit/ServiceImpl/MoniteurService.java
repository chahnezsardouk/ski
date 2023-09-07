package tn.esprit.esprit.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.esprit.Repository.CoursRepository;
import tn.esprit.esprit.Repository.MoniteurRepository;
import tn.esprit.esprit.ServiceInterfaces.IMoniteurService;
import tn.esprit.esprit.entities.Cours;
import tn.esprit.esprit.entities.Moniteur;

import java.util.List;
@Service
@AllArgsConstructor
public class MoniteurService implements IMoniteurService {
    MoniteurRepository moniteurRepository;
    CoursRepository coursRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addOrUpdateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public void removeMoniteur(Moniteur moniteur) {
        moniteurRepository.delete(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        moniteur.getCours().add(cours);
      return moniteurRepository.save(moniteur);
    }
}
