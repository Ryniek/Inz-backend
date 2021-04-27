package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class MajorEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, columnDefinition = "VARCHAR(25)")
    private String code;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EffectType type;

    @OneToMany(mappedBy = "majorEffect", cascade = CascadeType.PERSIST)
    private Set<MajorEffectModuleSubject> majorEffectModuleSubjects = new HashSet<>();

    @OneToMany(mappedBy = "majorEffect")
    private Set<MajorEffectSubjectIdea> majorEffectSubjectIdeas = new HashSet<>();

    @OneToMany(mappedBy = "majorEffect")
    private Set<EffectIdea> effectIdeas = new HashSet<>();

    @ManyToMany(mappedBy = "majorEffects", cascade = CascadeType.PERSIST)
    private Set<Major> majors = new HashSet<>();

    //pomocnicze do Many to Many - dajemy gdzie chcemy ale zapisujemy przez zarzadzajaca
    public void addMajor(Major major) {
        this.majors.add(major);
        major.getMajorEffects().add(this);
    }

    public void removeMajor(Major major) {
        this.majors.remove(major);
        major.getMajorEffects().remove(this);
    }

    //pomocnicze do one to many, jak chcemy dodać to dodajemy z dwóch stron i zapisujemy środkową encją
    public void addEffectIdea(EffectIdea effectIdea) {
        effectIdeas.add(effectIdea);
        effectIdea.setMajorEffect(this);
    }

    public void removeEffectIdea(EffectIdea effectIdea) {
        effectIdeas.remove(effectIdea);
        effectIdea.setMajorEffect(null);
    }
}
