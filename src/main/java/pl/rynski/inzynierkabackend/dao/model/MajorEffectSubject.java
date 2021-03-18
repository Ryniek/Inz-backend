package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MajorEffectSubject {

    @EmbeddedId
    private MajorEffectSubjectId id = new MajorEffectSubjectId();

    @ManyToOne
    @MapsId("subjectId")
    private Subject subject;

    @ManyToOne
    @MapsId("majorEffectId")
    private MajorEffect majorEffect;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
