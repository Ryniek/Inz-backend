package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class FieldOfStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "study_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyType studyType;

    @Column(name = "years", nullable = false)
    private String years;

    @Column(name = "hidden", nullable = false)
    private Boolean hidden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "fieldOfStudy")
    private Set<FieldModule> fieldModules = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "field_of_study_outcomes",
            joinColumns = @JoinColumn(name = "field_of_study_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "educational_outcomes_id", referencedColumnName = "id")
    )
    private Set<EducationalOutcomes> educationalOutcomes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "field_of_study_outcomes_idea",
            joinColumns = @JoinColumn(name = "field_of_study_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "educational_outcomes_idea_id", referencedColumnName = "id")
    )
    private Set<EducationalOutcomesIdea> educationalOutcomesIdeas = new HashSet<>();

    //pomocnie dodawania obiektow do relacji dajemy przy many to many gdzie chcemy
    public void addOutcomes(EducationalOutcomes outcomes) {
        this.educationalOutcomes.add(outcomes);
        outcomes.getFieldOfStudies().add(this);
    }

    public void removeOutcomes(EducationalOutcomes outcomes) {
        this.educationalOutcomes.remove(outcomes);
        outcomes.getFieldOfStudies().remove(this);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addFieldModule(FieldModule fieldModule) {
        fieldModules.add(fieldModule);
        fieldModule.setFieldOfStudy(this);
    }

    public void removeFieldModule(FieldModule fieldModule) {
        fieldModules.remove(fieldModule);
        fieldModule.setFieldOfStudy(null);
    }

    public void addOutcomesIdea(EducationalOutcomesIdea outcomesIdea) {
        this.educationalOutcomesIdeas.add(outcomesIdea);
        outcomesIdea.getFieldOfStudies().add(this);
    }

    public void removeOutcomesIdea(EducationalOutcomesIdea outcomesIdea) {
        this.educationalOutcomesIdeas.remove(outcomesIdea);
        outcomesIdea.getFieldOfStudies().remove(this);
    }
}
