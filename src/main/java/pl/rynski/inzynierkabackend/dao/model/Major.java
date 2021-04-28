package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "study_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StudyType studyType;

    @Column(name = "years", nullable = false)
    private String years;

    @Column(name = "hidden", nullable = false)
    private Boolean hidden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "major", orphanRemoval = true)
    private Set<MajorModule> majorModules = new HashSet<>();

    @OneToMany(mappedBy = "major", orphanRemoval = true)
    private Set<ModuleIdea> moduleIdeas = new HashSet<>();

    @OneToMany(mappedBy = "major")
    private Set<EffectIdea> effectIdeas = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "major_major_effect",
            joinColumns = @JoinColumn(name = "major_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "major_effect_id", referencedColumnName = "id")
    )
    private Set<MajorEffect> majorEffects = new HashSet<>();

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModule(MajorModule majorModule) {
        majorModules.add(majorModule);
        majorModule.setMajor(this);
    }

    public void removeMajorModule(MajorModule majorModule) {
        majorModules.remove(majorModule);
        majorModule.setMajor(null);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addEffectIdea(EffectIdea effectIdea) {
        effectIdeas.add(effectIdea);
        effectIdea.setMajor(this);
    }

    public void removeEffectIdea(EffectIdea effectIdea) {
        effectIdeas.remove(effectIdea);
        effectIdea.setMajor(null);
    }
}
