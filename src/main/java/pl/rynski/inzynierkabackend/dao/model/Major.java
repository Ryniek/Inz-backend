package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.dto.MajorDto;
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "major_effect",
            joinColumns = @JoinColumn(name = "major_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "effect_id", referencedColumnName = "id")
    )
    private Set<Effect> effects = new HashSet<>();

    //TODO tutaj chyba trza bedzie zmienic strone zarzadzajaca
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "major_effect_idea",
            joinColumns = @JoinColumn(name = "major_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "effect_idea_id", referencedColumnName = "id")
    )
    private Set<EffectIdea> effectIdeas = new HashSet<>();

    //pomocnie dodawania obiektow do relacji dajemy przy many to many gdzie chcemy
    public void addEffect(Effect effect) {
        this.effects.add(effect);
        effect.getMajors().add(this);
    }

    public void removeEffect(Effect effect) {
        this.effects.remove(effect);
        effect.getMajors().remove(this);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModule(MajorModule majorModule) {
        majorModules.add(majorModule);
        majorModule.setMajor(this);
    }

    public void removeMajorModule(MajorModule majorModule) {
        majorModules.remove(majorModule);
        majorModule.setMajor(null);
    }

    public void addEffectIdea(EffectIdea effectIdea) {
        this.effectIdeas.add(effectIdea);
        effectIdea.getMajors().add(this);
    }

    public void removeEffectIdea(EffectIdea effectIdea) {
        this.effectIdeas.remove(effectIdea);
        effectIdea.getMajors().remove(this);
    }

    public static Major fromDto(MajorDto dto) {
        Major major = new Major();
        major.setName(dto.getName());
        major.setStudyType(dto.getStudyType());
        major.setYears(dto.getYears());
        major.setHidden(dto.getHidden());
        return major;
    }
}