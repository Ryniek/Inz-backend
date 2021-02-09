package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MajorSubjectEffect {
    @EmbeddedId
    private MajorSubjectEffectId id = new MajorSubjectEffectId();

    @ManyToOne
    @MapsId("majorModuleSubjectId")
    private MajorModuleSubject majorModuleSubject;

    @ManyToOne
    @MapsId("effectId")
    private Effect effect;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
