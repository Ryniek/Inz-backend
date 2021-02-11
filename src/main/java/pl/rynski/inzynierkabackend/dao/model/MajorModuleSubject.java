package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_id", referencedColumnName = "id")
    private MajorModule majorModule;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_hours_id", referencedColumnName = "id")
    private ContactHours contactHours;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "non_contact_hours_id", referencedColumnName = "id")
    private NonContactHours nonContactHours;

    //TODO to chyba tez do wywalenia bedzie(orphan removal)
    @OneToMany(mappedBy = "majorModuleSubject")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @ManyToMany(mappedBy = "majorModuleSubjects")
    private Set<ModuleIdea> moduleIdeas = new HashSet<>();

    @OneToMany(mappedBy = "majorModuleSubject", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<MajorSubjectEffect> majorSubjectEffects = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "major_subject_effect_idea",
            joinColumns = @JoinColumn(name = "major_module_subject_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "effect_idea_id", referencedColumnName = "id")
    )
    private Set<EffectIdea> effectIdeas = new HashSet<>();

    public void addEffectIdea(EffectIdea effectIdea) {
        this.effectIdeas.add(effectIdea);
        effectIdea.getMajorModuleSubjects().add(this);
    }

    public void removeEffectIdea(EffectIdea effectIdea) {
        this.effectIdeas.remove(effectIdea);
        effectIdea.getMajorModuleSubjects().remove(this);
    }

    public void addSubjectIdea(SubjectIdea subjectIdea) {
        this.subjectIdeas.add(subjectIdea);
        subjectIdea.setMajorModuleSubject(this);
    }

    public void removeSubjectIdea(SubjectIdea subjectIdea) {
        this.subjectIdeas.remove(subjectIdea);
        subjectIdea.setMajorModuleSubject(null);
    }
}
