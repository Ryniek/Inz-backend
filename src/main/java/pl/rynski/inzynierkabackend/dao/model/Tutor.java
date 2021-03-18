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

    @OneToMany(mappedBy = "supervisor")
    private Set<MajorModuleSubject> majorModuleSubjectsSupervisor = new HashSet<>();

    @OneToMany(mappedBy = "tutor")
    private Set<MajorModuleSubject> majorModuleSubjects = new HashSet<>();

    @OneToMany(mappedBy = "supervisor")
    private Set<SubjectIdea> subjectIdeasSupervisor = new HashSet<>();

    @OneToMany(mappedBy = "tutor")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @OneToMany(mappedBy = "tutor")
    private Set<ModuleIdea> moduleIdeas = new HashSet<>();

    @OneToMany(mappedBy = "tutor")
    private Set<ModuleIdeaSubject> moduleIdeaSubjects = new HashSet<>();

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModule(MajorModule majorModule) {
        modules.add(majorModule);
        majorModule.setTutor(this);
    }

    public void removeMajorModule(MajorModule majorModule) {
        modules.remove(majorModule);
        majorModule.setTutor(null);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModuleSubject(MajorModuleSubject majorModuleSubject) {
        majorModuleSubjects.add(majorModuleSubject);
        majorModuleSubject.setTutor(this);
    }

    public void removeMajorModuleSubject(MajorModuleSubject majorModuleSubject) {
        majorModuleSubjects.remove(majorModuleSubject);
        majorModuleSubject.setTutor(null);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModuleSubjectSupervisor(MajorModuleSubject majorModuleSubject) {
        majorModuleSubjectsSupervisor.add(majorModuleSubject);
        majorModuleSubject.setSupervisor(this);
    }

    public void removeMajorModuleSubjectSupervisor(MajorModuleSubject majorModuleSubject) {
        majorModuleSubjectsSupervisor.remove(majorModuleSubject);
        majorModuleSubject.setSupervisor(null);
    }

    public void addSubjectIdea(SubjectIdea subjectIdea) {
        subjectIdeas.add(subjectIdea);
        subjectIdea.setTutor(this);
    }

    public void removeSubjectIdea(SubjectIdea subjectIdea) {
        subjectIdeas.remove(subjectIdea);
        subjectIdea.setTutor(null);
    }

    public void addSubjectIdeaSupervisor(SubjectIdea subjectIdea) {
        subjectIdeasSupervisor.add(subjectIdea);
        subjectIdea.setSupervisor(this);
    }

    public void removeSubjectIdeaSupervisor(SubjectIdea subjectIdea) {
        subjectIdeasSupervisor.remove(subjectIdea);
        subjectIdea.setSupervisor(null);
    }

    public void addModuleIdea(ModuleIdea moduleIdea) {
        moduleIdeas.add(moduleIdea);
        moduleIdea.setTutor(this);
    }

    public void removeModuleIdea(ModuleIdea moduleIdea) {
        moduleIdeas.remove(moduleIdea);
        moduleIdea.setTutor(null);
    }
}
