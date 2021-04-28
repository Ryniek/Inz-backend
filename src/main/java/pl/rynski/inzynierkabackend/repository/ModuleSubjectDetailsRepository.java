package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.MajorModuleSubjectDetails;

@Repository
public interface ModuleSubjectDetailsRepository extends JpaRepository<MajorModuleSubjectDetails, Long> {
}
