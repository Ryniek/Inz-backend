package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.ModuleIdea;

import java.util.List;

@Repository
public interface ModuleIdeaRepository extends PagingAndSortingRepository<ModuleIdea, Long> {
    List<ModuleIdea> findAllByApproved(Boolean approved, Pageable pageable);
}
