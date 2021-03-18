package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EffectIdeaMajor {

    @EmbeddedId
    private EffectIdeaMajorId id = new EffectIdeaMajorId();

    @ManyToOne
    @MapsId("effectIdeaId")
    private EffectIdea effectIdea;

    @ManyToOne
    @MapsId("majorId")
    private Major major;

    @Column(name = "connection_strength", nullable = false)
    private Integer connectionStrength;
}
