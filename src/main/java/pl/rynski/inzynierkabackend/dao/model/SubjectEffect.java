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

    @ManyToMany(mappedBy = "subjectEffects", cascade = CascadeType.PERSIST)
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @ManyToMany(mappedBy = "subjectEffects", cascade = CascadeType.PERSIST)
    private Set<MajorModuleSubject> majorModuleSubjects = new HashSet<>();
}
