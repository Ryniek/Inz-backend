package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.Department;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.Major;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
    List<Major> findAllByDepartmentAndHidden(Department department, Boolean hidden);
    List<Major> findAllByDepartment(Department department);
    List<Major> findAllByEffectsIn(List<Effect> effects);
    List<Major> findAllByHidden(Boolean hidden);
}
