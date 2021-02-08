package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "subject_code", nullable = false, unique = true, columnDefinition = "VARCHAR(20)")
    private String subjectCode;

    @Column(name = "ects", nullable = false)
    private Integer ects;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "contact_hours_id", referencedColumnName = "id")
    private ContactHours contactHours;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "non_contact_hours_id", referencedColumnName = "id")
    private NonContactHours nonContactHours;

    @OneToMany(mappedBy = "subject")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @ManyToMany(mappedBy = "subjects")
    private Set<ModuleIdea> moduleIdeas = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "subject_outcomes",
            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "educational_outcomes_id", referencedColumnName = "id")
    )
    private Set<EducationalOutcomes> educationalOutcomes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "subject_outcomes_idea",
            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "educational_outcomes_idea_id", referencedColumnName = "id")
    )
    private Set<EducationalOutcomesIdea> educationalOutcomesIdeas = new HashSet<>();

    public void addOutcomes(EducationalOutcomes outcomes) {
        this.educationalOutcomes.add(outcomes);
        outcomes.getSubjects().add(this);
    }

    public void removeOutcomes(EducationalOutcomes outcomes) {
        this.educationalOutcomes.remove(outcomes);
        outcomes.getSubjects().remove(this);
    }

    public void addOutcomesIdea(EducationalOutcomesIdea outcomesIdea) {
        this.educationalOutcomesIdeas.add(outcomesIdea);
        outcomesIdea.getSubjects().add(this);
    }

    public void removeOutcomesIdea(EducationalOutcomesIdea outcomesIdea) {
        this.educationalOutcomesIdeas.remove(outcomesIdea);
        outcomesIdea.getSubjects().remove(this);
    }
}
