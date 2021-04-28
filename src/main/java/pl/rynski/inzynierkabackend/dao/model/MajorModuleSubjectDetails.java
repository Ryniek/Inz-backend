package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class MajorModuleSubjectDetails {
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
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_subject_id", referencedColumnName = "id")
    private MajorModuleSubject majorModuleSubject;

    @OneToMany(mappedBy = "majorModuleSubjectDetails", orphanRemoval = true)
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    public void addSubjectIdea(SubjectIdea subjectIdea) {
        this.subjectIdeas.add(subjectIdea);
        subjectIdea.setMajorModuleSubjectDetails(this);
    }

    public void removeSubjectIdea(SubjectIdea subjectIdea) {
        this.subjectIdeas.remove(subjectIdea);
        subjectIdea.setMajorModuleSubjectDetails(null);
    }
}
