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
    private Boolean existing = false;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "to_remove", nullable = false)
    private Boolean toRemove = false;

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

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "ects")
    private Integer ects;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_hours_id", referencedColumnName = "id")
    private ContactHours contactHours;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "non_contact_hours_id", referencedColumnName = "id")
    private NonContactHours nonContactHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_id", referencedColumnName = "id")
    private MajorModule majorModule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    //Jezeli modyfikujemy istniejacy, gdy exising == true
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_subject_id", referencedColumnName = "id")
    private MajorModuleSubject majorModuleSubject;

    //TODO wyswietlac te przy all SubjectIdea ktore maja moduleIdea == null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_idea_id", referencedColumnName = "id")
    private ModuleIdea moduleIdea;

    @OneToMany(mappedBy = "subjectIdea", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<SubjectIdeaEffect> subjectIdeaEffects = new HashSet<>();

    //pomocnicze do one to many, jak chcemy dodać to dodajemy z dwóch stron i zapisujemy środkową encją
    public void addSubjectIdeaEffect(SubjectIdeaEffect subjectIdeaEffect) {
        subjectIdeaEffects.add(subjectIdeaEffect);
        subjectIdeaEffect.setSubjectIdea(this);
    }

    public void removeSubjectIdeaEffect(SubjectIdeaEffect subjectIdeaEffect) {
        subjectIdeaEffects.remove(subjectIdeaEffect);
        subjectIdeaEffect.setSubjectIdea(null);
    }
}
