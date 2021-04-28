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
    private Boolean existing = false;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "to_remove", nullable = false)
    private Boolean toRemove = false;

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
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    //Kiedy existing == true
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_id", referencedColumnName = "id")
    private MajorModule majorModule;

    //Kiedy nowy moduł dla kierunku
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    private Major major;

    //Stworzone nowe przedmioty do modułu
    @OneToMany(mappedBy = "moduleIdea", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<ModuleIdeaNewSubject> newSubjects = new HashSet<>();

    //Wybrane istniejace przedmiotu do modułu
    @OneToMany(mappedBy = "moduleIdea", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<ModuleIdeaExistingSubject> moduleIdeaExistingSubjects = new HashSet<>();

    //pomocnicze dajemy tam gdzie one to many
    public void addNewSubject(ModuleIdeaNewSubject newSubject) {
        newSubjects.add(newSubject);
        newSubject.setModuleIdea(this);
    }

    public void removeNewSubject(ModuleIdeaNewSubject newSubject) {
        newSubjects.remove(newSubject);
        newSubject.setModuleIdea(null);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addExistingSubject(ModuleIdeaExistingSubject existingSubject) {
        moduleIdeaExistingSubjects.add(existingSubject);
        existingSubject.setModuleIdea(this);
    }

    public void removeExistingSubject(ModuleIdeaExistingSubject existingSubject) {
        moduleIdeaExistingSubjects.remove(existingSubject);
        existingSubject.setModuleIdea(null);
    }
}
