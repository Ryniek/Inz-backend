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
}
