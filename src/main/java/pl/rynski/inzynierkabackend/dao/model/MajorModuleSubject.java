package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class MajorModuleSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ects", nullable = false)
    private Integer ects;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    @Column(name = "type_of_passing", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeOfPassing typeOfPassing;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_hours_id", referencedColumnName = "id")
    private ContactHours contactHours;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "non_contact_hours_id", referencedColumnName = "id")
    private NonContactHours nonContactHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_id", referencedColumnName = "id")
    private MajorModule majorModule;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    private Tutor supervisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @OneToMany(mappedBy = "majorModuleSubject", orphanRemoval = true)
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    public void addSubjectIdea(SubjectIdea subjectIdea) {
        this.subjectIdeas.add(subjectIdea);
        subjectIdea.setMajorModuleSubject(this);
    }

    public void removeSubjectIdea(SubjectIdea subjectIdea) {
        this.subjectIdeas.remove(subjectIdea);
        subjectIdea.setMajorModuleSubject(null);
    }
}
