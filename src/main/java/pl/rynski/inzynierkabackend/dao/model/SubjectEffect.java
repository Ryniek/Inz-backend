package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SubjectEffect {
    @EmbeddedId
    private SubjectEffectId id = new SubjectEffectId();

    @ManyToOne
    @MapsId("subjectId")
    private Subject subject;

    @ManyToOne
    @MapsId("effectId")
    private Effect effect;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
