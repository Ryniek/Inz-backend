package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.EducationalOutcomesType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class EducationalOutcomes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, columnDefinition = "VARCHAR(25)")
    private String code;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EducationalOutcomesType type;

    @Column(name = "for_subject")
    private Boolean forSubject;

    @Column(name = "for_field")
    private Boolean forField;

    @ManyToMany(mappedBy = "educationalOutcomes")
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany(mappedBy = "educationalOutcomes")
    private Set<FieldOfStudy> fieldOfStudies = new HashSet<>();

    @OneToMany(mappedBy = "educationalOutcomes")
    private Set<SubjectIdeaOutcomes> subjectIdeaOutcomes = new HashSet<>();

    @OneToMany(mappedBy = "educationalOutcomes")
    private Set<EducationalOutcomesIdea> educationalOutcomesIdeas = new HashSet<>();

    //pomocnicze do one to many, jak chcemy dodać to dodajemy z dwóch stron i zapisujemy środkową encją
    public void addSubjectIdeaOutcomes(SubjectIdeaOutcomes subjectIdeaOutcome) {
        subjectIdeaOutcomes.add(subjectIdeaOutcome);
        subjectIdeaOutcome.setEducationalOutcomes(this);
    }

    public void removeSubjectIdeaOutcomes(SubjectIdeaOutcomes subjectIdeaOutcome) {
        subjectIdeaOutcomes.remove(subjectIdeaOutcome);
        subjectIdeaOutcome.setEducationalOutcomes(null);
    }
}
