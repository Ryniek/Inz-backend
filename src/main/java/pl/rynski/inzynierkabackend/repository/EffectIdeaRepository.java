package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.EffectIdea;
import pl.rynski.inzynierkabackend.dao.model.ModuleIdea;

import java.util.List;

@Repository
public interface EffectIdeaRepository extends PagingAndSortingRepository<EffectIdea, Long> {
    List<EffectIdea> findAllByApproved(Boolean approved, Pageable pageable);
}
