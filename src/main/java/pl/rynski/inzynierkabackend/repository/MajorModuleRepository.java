package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;

import java.util.List;

@Repository
public interface MajorModuleRepository extends JpaRepository<MajorModule, Long> {
    List<MajorModule> findAllByMajor(Major major);
}
