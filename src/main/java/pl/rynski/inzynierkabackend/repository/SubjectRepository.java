package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.Subject;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySubjectCode(String subjectCode);
}
