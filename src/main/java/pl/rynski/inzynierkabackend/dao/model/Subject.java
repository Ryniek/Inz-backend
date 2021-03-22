package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "subject_code", nullable = false, unique = true, columnDefinition = "VARCHAR(20)")
    private String subjectCode;

    @OneToMany(mappedBy = "subject")
    private Set<MajorEffectSubject> majorEffects = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<MajorModuleSubject> majorModuleSubjects = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<ModuleIdeaSubject> moduleIdeaSubjects = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<EffectIdea> effectIdeas = new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private Set<EffectIdeaSubject> effectIdeaSubjects = new HashSet<>();

    @ManyToMany(mappedBy = "subjects")
    private Set<EffectIdea> subjectEffectIdeas = new HashSet<>();

    @ManyToMany(mappedBy = "subjects")
    private Set<Module> modules = new HashSet<>();

    @ManyToMany(mappedBy = "subjects")
    private Set<SubjectEffect> subjectEffects = new HashSet<>();

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModuleSubject(MajorModuleSubject majorModuleSubject) {
        majorModuleSubjects.add(majorModuleSubject);
        majorModuleSubject.setSubject(this);
    }

    public void removeMajorModuleSubject(MajorModuleSubject majorModuleSubject) {
        majorModuleSubjects.remove(majorModuleSubject);
        majorModuleSubject.setSubject(null);
    }
}
