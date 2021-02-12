package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ModuleIdeaSubject {
    @EmbeddedId
    private ModuleIdeaSubjectId id = new ModuleIdeaSubjectId();

    @ManyToOne
    @MapsId("moduleIdeaId")
    private ModuleIdea moduleIdea;

    @ManyToOne
    @MapsId("majorModuleSubjectId")
    private MajorModuleSubject majorModuleSubject;

    @Column(name = "semester", nullable = false)
    private Integer semester;
}
