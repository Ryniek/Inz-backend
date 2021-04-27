package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MajorEffectModuleSubject {

    @EmbeddedId
    private MajorEffectModuleSubjectId id = new MajorEffectModuleSubjectId();

    @ManyToOne
    @MapsId("majorModuleSubjectId")
    private MajorModuleSubject majorModuleSubject;

    @ManyToOne
    @MapsId("majorEffectId")
    private MajorEffect majorEffect;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
