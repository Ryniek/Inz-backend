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
public class MajorEffect {
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

    @OneToMany(mappedBy = "majorEffect", cascade = CascadeType.PERSIST)
    private Set<MajorEffectSubject> majorEffectSubjects = new HashSet<>();

    @OneToMany(mappedBy = "majorEffect")
    private Set<MajorEffectSubjectIdea> majorEffectSubjectIdeas = new HashSet<>();

    @ManyToMany(mappedBy = "majorEffects")
    private Set<Major> majors = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "major_effect_subject_effect",
            joinColumns = @JoinColumn(name = "major_effect_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "subject_effect_id", referencedColumnName = "id")
    )
    private Set<SubjectEffect> subjectEffects = new HashSet<>();
}
