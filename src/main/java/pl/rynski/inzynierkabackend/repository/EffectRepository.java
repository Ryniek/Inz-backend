package pl.rynski.inzynierkabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.rynski.inzynierkabackend.dao.model.Effect;

import java.util.List;

@Repository
public interface EffectRepository extends JpaRepository<Effect, Long> {
    List<Effect> findAllByForSubject(Boolean forSubject);

    @Query( "SELECT e FROM Effect e WHERE e.id IN :ids AND e.forMajor = TRUE" )
    List<Effect> findByIdsAndForMajor(@Param("ids") List<Long> ids);
}
