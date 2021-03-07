package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;

import java.util.List;

public interface SubjectEffectRepository extends JpaRepository<SubjectEffect, Long> {
    List<SubjectEffect> findAllByEffect(Effect effect);
}
