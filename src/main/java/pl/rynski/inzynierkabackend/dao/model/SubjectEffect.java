package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//TODO getAllSubjectEffects
@Entity
@Getter
@Setter
public class SubjectEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, unique = true, columnDefinition = "VARCHAR(250)")
    private String content;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EffectType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_subject_id", referencedColumnName = "id")
    private MajorModuleSubject majorModuleSubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_idea_id", referencedColumnName = "id")
    private SubjectIdea subjectIdea;
}
