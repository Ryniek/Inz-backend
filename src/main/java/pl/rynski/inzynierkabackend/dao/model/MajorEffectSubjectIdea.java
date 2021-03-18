package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MajorEffectSubjectIdea {
    @EmbeddedId
    private MajorEffectSubjectIdeaId id = new MajorEffectSubjectIdeaId();

    @ManyToOne
    @MapsId("subjectIdeaId")
    private SubjectIdea subjectIdea;

    @ManyToOne
    @MapsId("majorEffectId")
    private MajorEffect majorEffect;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
