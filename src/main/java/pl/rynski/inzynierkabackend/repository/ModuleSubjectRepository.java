package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.MajorModuleSubject;

@Repository
public interface ModuleSubjectRepository extends JpaRepository<MajorModuleSubject, Long> {
}
