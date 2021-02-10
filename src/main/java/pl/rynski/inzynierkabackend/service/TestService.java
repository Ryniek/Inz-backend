package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;
import pl.rynski.inzynierkabackend.repository.MajorRepository;
import pl.rynski.inzynierkabackend.repository.ModuleRepository;

@Service
@RequiredArgsConstructor
public class TestService {

    private final MajorRepository majorRepository;
    private final ModuleRepository moduleRepository;
    private final PasswordEncoder passwordEncoder;

    //@EventListener(ApplicationReadyEvent.class)
    public void test() {
        //Jesli rekordu wgl nie ma, to trzeba dodać .save albo zrobić cascade=PERSIST po stronie zarzadzajacej i doda sie samo
        //Jeśli rekord jest, to wystarczy użyć metody pomocniczej i zapisać encję przez strone zarządającą
        //Tutaj Module jest strona zarzadzajaca(ma JoinColumn)
        //Nie mamy tutaj cascade=PERSISTS wiec dodajemy recznie
        //Orphan removal na stronie nie zarzadzajacej(tylko tam mozna, gdzie jest lista) daje to,
        // że usuwa wszystkie rekordy co sa w liscie jak usuniemy rekord zawierajacy ta liste
        Major major = new Major();
        major.setName("Test");
        major.setStudyType(StudyType.FIRST_FULL);
        major.setYears("2010/2014");
        major.setHidden(false);
        majorRepository.save(major);
        Module module = new Module();
        module.setName("Test");
        module.setSpecialized(true);
        //fieldOfStudy.addModule(module);
        moduleRepository.save(module);
/*        fieldOfStudy.removeModule(module);
        moduleRepository.save(module);*/
        majorRepository.delete(major);
        System.out.println(passwordEncoder.encode("string"));
    }
}
