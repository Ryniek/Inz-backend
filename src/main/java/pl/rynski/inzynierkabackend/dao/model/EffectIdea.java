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

    @OneToMany(mappedBy = "effectIdea", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<SubjectEffectIdea> subjectEffectIdeas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "effect_idea_major",
            joinColumns = @JoinColumn(name = "effect_idea_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "major_id", referencedColumnName = "id")
    )    private Set<Major> majors = new HashSet<>();

    public void addMajor(Major major) {
        this.majors.add(major);
        major.getEffectIdeas().add(this);
    }

    public void removeMajor(Major major) {
        this.majors.remove(major);
        major.getEffectIdeas().remove(this);
    }
}
