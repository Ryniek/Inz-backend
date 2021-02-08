package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SubjectIdeaOutcomes {

    @EmbeddedId
    private SubjectIdeaOutcomesId id = new SubjectIdeaOutcomesId();

    @ManyToOne
    @MapsId("subjectIdeaId")
    private SubjectIdea subjectIdea;

    @ManyToOne
    @MapsId("educationalOutcomesId")
    private EducationalOutcomes educationalOutcomes;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
