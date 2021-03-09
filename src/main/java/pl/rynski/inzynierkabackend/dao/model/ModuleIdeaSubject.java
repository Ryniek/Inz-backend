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
    @MapsId("subjectId")
    private Subject subject;

    @ManyToOne
    @MapsId("tutorId")
    private Tutor tutor;

    @Column(name = "ects", nullable = false)
    private Integer ects;
}
