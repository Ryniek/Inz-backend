package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class SubjectEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, columnDefinition = "VARCHAR(25)")
    private String code;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EffectType type;

    @ManyToMany(mappedBy = "subjectEffects", cascade = CascadeType.PERSIST)
    private Set<MajorEffect> majorEffects = new HashSet<>();

    @ManyToMany(mappedBy = "subjectEffects")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "subject_subject_effect",
            joinColumns = @JoinColumn(name = "subject_effect_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private Set<Subject> subjects = new HashSet<>();
}
