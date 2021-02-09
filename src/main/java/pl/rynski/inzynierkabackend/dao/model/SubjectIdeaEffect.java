package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SubjectIdeaEffect {

    @EmbeddedId
    private SubjectIdeaEffectId id = new SubjectIdeaEffectId();

    @ManyToOne
    @MapsId("subjectIdeaId")
    private SubjectIdea subjectIdea;

    @ManyToOne
    @MapsId("effectId")
    private Effect effect;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
