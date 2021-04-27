package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EffectIdeaModuleSubject {

    @EmbeddedId
    private EffectIdeaModuleSubjectId id = new EffectIdeaModuleSubjectId();

    @ManyToOne
    @MapsId("effectIdeaId")
    private EffectIdea effectIdea;

    @ManyToOne
    @MapsId("majorModuleSubjectId")
    private MajorModuleSubject majorModuleSubject;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
