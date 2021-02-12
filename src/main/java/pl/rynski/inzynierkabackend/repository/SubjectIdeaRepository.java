package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.SubjectIdea;

import java.util.List;

@Repository
public interface SubjectIdeaRepository extends PagingAndSortingRepository<SubjectIdea, Long> {
    List<SubjectIdea> findAllByApproved(Boolean approved, Pageable pageable);
}
