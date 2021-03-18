package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EffectIdeaSubject {

    @EmbeddedId
    private EffectIdeaSubjectId id = new EffectIdeaSubjectId();

    @ManyToOne
    @MapsId("effectIdeaId")
    private EffectIdea effectIdea;

    @ManyToOne
    @MapsId("subjectId")
    private Subject subject;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
