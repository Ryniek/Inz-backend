package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class SubjectIdea {
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

    @Column(name = "subject_name", columnDefinition = "VARCHAR(250)")
    private String subjectName;

    @Column(name = "idea_explanation", nullable = false, columnDefinition = "TEXT")
    private String ideaExplanation;

    @Column(name = "goals", columnDefinition = "TEXT")
    private String goals;

    @Column(name = "resources_needed", columnDefinition = "TEXT")
    private String resourcesNeeded;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    @Column(name = "ects")
    private Integer ects;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "contact_hours_id", referencedColumnName = "id")
    private ContactHours contactHours;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "non_contact_hours_id", referencedColumnName = "id")
    private NonContactHours nonContactHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_module_id", referencedColumnName = "id")
    private FieldModule fieldModule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    //Jezeli modyfikujemy istniejacy, gdy exising == true
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_module_subject_id", referencedColumnName = "id")
    private FieldModuleSubject fieldModuleSubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_idea_id", referencedColumnName = "id")
    private ModuleIdea moduleIdea;

    @OneToMany(mappedBy = "subjectIdea")
    private Set<SubjectIdeaOutcomes> subjectIdeaOutcomes = new HashSet<>();

    //pomocnicze do one to many, jak chcemy dodać to dodajemy z dwóch stron i zapisujemy środkową encją
    public void addSubjectIdeaOutcomes(SubjectIdeaOutcomes subjectIdeaOutcome) {
        subjectIdeaOutcomes.add(subjectIdeaOutcome);
        subjectIdeaOutcome.setSubjectIdea(this);
    }

    public void removeSubjectIdeaOutcomes(SubjectIdeaOutcomes subjectIdeaOutcome) {
        subjectIdeaOutcomes.remove(subjectIdeaOutcome);
        subjectIdeaOutcome.setSubjectIdea(null);
    }
}
