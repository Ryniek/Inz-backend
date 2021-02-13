package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.EffectIdea;

@Repository
public interface EffectIdeaRepository extends PagingAndSortingRepository<EffectIdea, Long> {
}
