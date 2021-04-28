package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;

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

    @Column(name = "type_of_passing")
    @Enumerated(EnumType.STRING)
    private TypeOfPassing typeOfPassing;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_hours_id", referencedColumnName = "id")
    private ContactHours contactHours;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "non_contact_hours_id", referencedColumnName = "id")
    private NonContactHours nonContactHours;

    //Wybrany moduł dla nowego przedmiotu lub propozycja zmiany modułu
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_id", referencedColumnName = "id")
    private MajorModule majorModule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    private Tutor supervisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    //Jezeli modyfikujemy istniejacy, gdy exising == true
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_subject_details_id", referencedColumnName = "id")
    private MajorModuleSubjectDetails majorModuleSubjectDetails;

    @OneToMany(mappedBy = "subjectIdea", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<MajorEffectSubjectIdea> majorEffectSubjectIdeas = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "subject_effect_subject_idea",
            joinColumns = @JoinColumn(name = "subject_idea_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "subject_effect_id", referencedColumnName = "id")
    )
    private Set<SubjectEffect> subjectEffects = new HashSet<>();

    //pomocnicze do Many to Many - dajemy gdzie chcemy ale zapisujemy przez zarzadzajaca
    public void addSubjectEffect(SubjectEffect subjectEffect) {
        this.subjectEffects.add(subjectEffect);
        subjectEffect.getSubjectIdeas().add(this);
    }

    public void removeSubjectEffect(SubjectEffect subjectEffect) {
        this.subjectEffects.remove(subjectEffect);
        subjectEffect.getSubjectIdeas().remove(this);
    }
}
