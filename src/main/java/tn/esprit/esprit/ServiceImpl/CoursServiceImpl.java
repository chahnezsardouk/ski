package tn.esprit.esprit.ServiceImpl;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprit.Repository.CoursRepository;
import tn.esprit.esprit.ServiceInterfaces.ICoursService;
import tn.esprit.esprit.entities.Cours;
import tn.esprit.esprit.entities.Inscription;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursServiceImpl implements ICoursService {
    //@Autowired
    CoursRepository coursRepository;
    @Override
    public List<Cours> retrieveAllCourses() {

        return coursRepository.findAll();
    }

    @Override
    public Cours addOrUpdateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public void removeCours(Cours cours) {
        coursRepository.delete(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }

}
