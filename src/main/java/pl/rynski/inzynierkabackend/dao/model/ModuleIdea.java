package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class ModuleIdea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "existing", nullable = false)
    private Boolean existing;

    @Column(name = "approved", nullable = false)
    private Boolean approved;

    @Column(name = "to_remove", nullable = false)
    private Boolean toRemove;

    @Column(name = "sending_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime sendingTime;

    @Column(name = "module_name", columnDefinition = "VARCHAR(250)")
    private String moduleName;

    @Column(name = "idea_explanation", nullable = false, columnDefinition = "TEXT")
    private String ideaExplanation;

    @Column(name = "graduate_skills", columnDefinition = "TEXT")
    private String graduateSkills;

    @Column(name = "potential_employers", columnDefinition = "TEXT")
    private String potentialEmployers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_id", referencedColumnName = "id")
    private MajorModule majorModule;

    //Stworzone nowe przedmioty do modułu
    @OneToMany(mappedBy = "moduleIdea")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    //TODO To rozkminic. Moze tu lepiej zrobic nowa tabele na te dane(propozycja nauczyciela, ects)
    //Wybrane istniejące przedmioty do modułu
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "module_idea_subject",
            joinColumns = @JoinColumn(name = "module_idea_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "major_module_subject_id", referencedColumnName = "id")
    )
    private Set<MajorModuleSubject> majorModuleSubjects = new HashSet<>();

    //pomocne dodawania obiektow do relacji dajemy przy many to many gdzie chcemy
    public void addMajorModuleSubject(MajorModuleSubject majorModuleSubject) {
        this.majorModuleSubjects.add(majorModuleSubject);
        majorModuleSubject.getModuleIdeas().add(this);
    }

    public void removeMajorModuleSubject(MajorModuleSubject majorModuleSubject) {
        this.majorModuleSubjects.remove(majorModuleSubject);
        majorModuleSubject.getModuleIdeas().remove(this);
    }
}
