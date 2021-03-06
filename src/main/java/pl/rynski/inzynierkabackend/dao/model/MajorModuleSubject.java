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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_module_id", referencedColumnName = "id")
    private MajorModule majorModule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    private Tutor supervisor;

    @OneToMany(mappedBy = "majorModuleSubject")
    private Set<MajorEffectModuleSubject> majorEffects = new HashSet<>();

    @OneToMany(mappedBy = "majorModuleSubject")
    private Set<EffectIdeaModuleSubject> effectIdeaModuleSubject = new HashSet<>();

    @OneToMany(mappedBy = "majorModuleSubject", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<MajorModuleSubjectDetails> majorModuleSubjectDetails = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "subject_effect_module_subject",
            joinColumns = @JoinColumn(name = "major_module_subject_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "subject_effect_id", referencedColumnName = "id")
    )
    private Set<SubjectEffect> subjectEffects = new HashSet<>();

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModuleSubjectDetails(MajorModuleSubjectDetails details) {
        majorModuleSubjectDetails.add(details);
        details.setMajorModuleSubject(this);
    }

    public void removeMajorModuleSubjectDetails(MajorModuleSubjectDetails details) {
        majorModuleSubjectDetails.remove(details);
        details.setMajorModuleSubject(null);
    }

    //pomocnicze do Many to Many - dajemy gdzie chcemy ale zapisujemy przez zarzadzajaca
    public void addSubjectEffect(SubjectEffect subjectEffect) {
        this.subjectEffects.add(subjectEffect);
        subjectEffect.getMajorModuleSubjects().add(this);
    }

    public void removeSubjectEffect(SubjectEffect subjectEffect) {
        this.subjectEffects.remove(subjectEffect);
        subjectEffect.getMajorModuleSubjects().remove(this);
    }
}
