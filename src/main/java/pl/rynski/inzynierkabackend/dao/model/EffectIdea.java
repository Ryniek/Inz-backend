package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class EffectIdea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "existing", nullable = false)
    private Boolean existing = false;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "to_remove", nullable = false)
    private Boolean toRemove = false;

    @Column(name = "sending_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime sendingTime;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "idea_explanation", nullable = false, columnDefinition = "TEXT")
    private String ideaExplanation;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EffectType type;

    @Column(name = "for_major")
    private Boolean forMajor;

    @Column(name = "for_subject")
    private Boolean forSubject;

    //Jezeli modyfikujemy istniejacy, gdy exising == true
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_effect_id", referencedColumnName = "id")
    private SubjectEffect subjectEffect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_effect_id", referencedColumnName = "id")
    private MajorEffect majorEffect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "effectIdea", cascade = CascadeType.PERSIST)
    private Set<EffectIdeaMajor> effectIdeaMajors = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "effect_idea_subject",
            joinColumns = @JoinColumn(name = "effect_idea_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private Set<Subject> subjects = new HashSet<>();
}
