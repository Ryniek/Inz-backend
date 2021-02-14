package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SubjectEffectIdea {
    @EmbeddedId
    private SubjectEffectIdeaId id = new SubjectEffectIdeaId();

    @ManyToOne
    @MapsId("majorModuleSubjectId")
    private MajorModuleSubject majorModuleSubject;

    @ManyToOne
    @MapsId("effectIdeaId")
    private EffectIdea effectIdea;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
