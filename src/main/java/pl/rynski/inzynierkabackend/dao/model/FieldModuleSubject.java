package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class FieldModuleSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ects", nullable = false)
    private Integer ects;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_module_id", referencedColumnName = "id")
    private FieldModule fieldModule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "contact_hours_id", referencedColumnName = "id")
    private ContactHours contactHours;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "non_contact_hours_id", referencedColumnName = "id")
    private NonContactHours nonContactHours;

    @OneToMany(mappedBy = "fieldModuleSubject")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @ManyToMany(mappedBy = "fieldModuleSubjects")
    private Set<ModuleIdea> moduleIdeas = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "field_module_subject_outcomes",
            joinColumns = @JoinColumn(name = "field_module_subject_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "educational_outcomes_id", referencedColumnName = "id")
    )
    private Set<EducationalOutcomes> educationalOutcomes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "field_subject_outcomes_idea",
            joinColumns = @JoinColumn(name = "field_module_subject_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "educational_outcomes_idea_id", referencedColumnName = "id")
    )
    private Set<EducationalOutcomesIdea> educationalOutcomesIdeas = new HashSet<>();

    public void addOutcomes(EducationalOutcomes outcomes) {
        this.educationalOutcomes.add(outcomes);
        outcomes.getFieldModuleSubjects().add(this);
    }

    public void removeOutcomes(EducationalOutcomes outcomes) {
        this.educationalOutcomes.remove(outcomes);
        outcomes.getFieldModuleSubjects().remove(this);
    }

    public void addOutcomesIdea(EducationalOutcomesIdea outcomesIdea) {
        this.educationalOutcomesIdeas.add(outcomesIdea);
        outcomesIdea.getFieldModuleSubjects().add(this);
    }

    public void removeOutcomesIdea(EducationalOutcomesIdea outcomesIdea) {
        this.educationalOutcomesIdeas.remove(outcomesIdea);
        outcomesIdea.getFieldModuleSubjects().remove(this);
    }
}
