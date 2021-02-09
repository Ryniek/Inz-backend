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
    private Boolean existing;

    @Column(name = "approved", nullable = false)
    private Boolean approved;

    @Column(name = "to_remove", nullable = false)
    private Boolean toRemove;

    @Column(name = "sending_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime sendingTime;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "idea_explanation", nullable = false, columnDefinition = "TEXT")
    private String ideaExplanation;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EffectType type;

    @Column(name = "for_subject")
    private Boolean forSubject;

    @Column(name = "for_major")
    private Boolean forMajor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    //Jezeli modyfikujemy istniejacy, gdy exising == true
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "effect_id", referencedColumnName = "id")
    private Effect effect;

    @ManyToMany(mappedBy = "effectIdeas")
    private Set<MajorModuleSubject> majorModuleSubjects = new HashSet<>();

    @ManyToMany(mappedBy = "effectIdeas")
    private Set<Major> majors = new HashSet<>();
}
