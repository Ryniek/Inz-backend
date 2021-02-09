package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class FieldModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_of_study_id", referencedColumnName = "id")
    private FieldOfStudy fieldOfStudy;

    //TODO tutaj rozważyć EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @OneToMany(mappedBy = "fieldModule")
    private Set<FieldModuleSubject> fieldModuleSubjects = new HashSet<>();

    @OneToMany(mappedBy = "fieldModule")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @OneToMany(mappedBy = "fieldModule")
    private Set<ModuleIdea> moduleIdeas = new HashSet<>();
}
