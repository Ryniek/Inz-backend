package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "degree", nullable = false)
    private String degree;

    @OneToMany(mappedBy = "tutor")
    private Set<MajorModule> modules = new HashSet<>();

    @OneToMany(mappedBy = "tutor")
    private Set<MajorModuleSubject> majorModuleSubjects = new HashSet<>();

    @OneToMany(mappedBy = "tutor")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

}
