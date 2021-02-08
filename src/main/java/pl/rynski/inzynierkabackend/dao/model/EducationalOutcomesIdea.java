package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.EducationalOutcomesType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class EducationalOutcomesIdea {
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
    private EducationalOutcomesType type;

    @Column(name = "for_subject")
    private Boolean forSubject;

    @Column(name = "for_field")
    private Boolean forField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    //Jezeli modyfikujemy istniejacy, gdy exising == true
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "educational_outcomes_id", referencedColumnName = "id")
    private EducationalOutcomes educationalOutcomes;

    @ManyToMany(mappedBy = "educationalOutcomesIdeas")
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany(mappedBy = "educationalOutcomesIdeas")
    private Set<FieldOfStudy> fieldOfStudies = new HashSet<>();
}
