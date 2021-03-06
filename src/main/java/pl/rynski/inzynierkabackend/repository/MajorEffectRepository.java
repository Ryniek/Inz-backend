package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;

import java.util.List;

@Repository
public interface MajorEffectRepository extends JpaRepository<MajorEffect, Long> {
    List<MajorEffect> findAllByMajors_Id(Long id);
}
