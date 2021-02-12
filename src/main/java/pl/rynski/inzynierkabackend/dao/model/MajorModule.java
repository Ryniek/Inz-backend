package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class MajorModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    private Major major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @OneToMany(mappedBy = "majorModule", orphanRemoval = true)
    private Set<MajorModuleSubject> majorModuleSubjects = new HashSet<>();

    @OneToMany(mappedBy = "majorModule", orphanRemoval = true)
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @OneToMany(mappedBy = "majorModule", orphanRemoval = true)
    private Set<ModuleIdea> moduleIdeas = new HashSet<>();

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModuleSubject(MajorModuleSubject moduleSubject) {
        majorModuleSubjects.add(moduleSubject);
        moduleSubject.setMajorModule(this);
    }

    public void removeMajorModuleSubject(MajorModuleSubject moduleSubject) {
        majorModuleSubjects.remove(moduleSubject);
        moduleSubject.setMajorModule(null);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addSubjectIdea(SubjectIdea subjectIdea) {
        subjectIdeas.add(subjectIdea);
        subjectIdea.setMajorModule(this);
    }

    public void removeSubjectIdea(SubjectIdea subjectIdea) {
        subjectIdeas.remove(subjectIdea);
        subjectIdea.setMajorModule(null);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addModuleIdea(ModuleIdea moduleIdea) {
        moduleIdeas.add(moduleIdea);
        moduleIdea.setMajorModule(this);
    }

    public void removeModuleIdea(ModuleIdea moduleIdea) {
        moduleIdeas.remove(moduleIdea);
        moduleIdea.setMajorModule(null);
    }
}
