package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.model.FieldOfStudy;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyDegree;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;
import pl.rynski.inzynierkabackend.repository.FieldOfStudyRepository;
import pl.rynski.inzynierkabackend.repository.ModuleRepository;

@Service
@RequiredArgsConstructor
public class TestService {
    private final FieldOfStudyRepository fieldOfStudyRepository;
    private final ModuleRepository moduleRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        //Jesli rekordu wgl nie ma, to trzeba dodać .save albo zrobić cascade=PERSIST po stronie zarzadzajacej i doda sie samo
        //Jeśli rekord jest, to wystarczy użyć metody pomocniczej i zapisać encję przez strone zarządającą
        //Tutaj Module jest strona zarzadzajaca(ma JoinColumn)
        //Nie mamy tutaj cascade=PERSISTS wiec dodajemy recznie
        //Orphan removal na stronie nie zarzadzajacej(tylko tam mozna, gdzie jest lista) daje to,
        // że usuwa wszystkie rekordy co sa w liscie jak usuniemy rekord zawierajacy ta liste
        FieldOfStudy fieldOfStudy = new FieldOfStudy();
        fieldOfStudy.setName("Test");
        fieldOfStudy.setStudyType(StudyType.CIVIL);
        fieldOfStudy.setStudyDegree(StudyDegree.FIRST_FULL);
        fieldOfStudyRepository.save(fieldOfStudy);
        Module module = new Module();
        module.setName("Test");
        module.setSpecialized(true);
        fieldOfStudy.addModule(module);
        moduleRepository.save(module);
/*        fieldOfStudy.removeModule(module);
        moduleRepository.save(module);*/
        fieldOfStudyRepository.delete(fieldOfStudy);
    }
}
