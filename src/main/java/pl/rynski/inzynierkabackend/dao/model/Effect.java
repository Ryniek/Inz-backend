package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.dto.EffectDto;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Effect {
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

    @Column(name = "for_subject")
    private Boolean forSubject;

    @Column(name = "for_major")
    private Boolean forMajor;

    @OneToMany(mappedBy = "effect")
    private Set<MajorSubjectEffect> majorSubjectEffects = new HashSet<>();

    @ManyToMany(mappedBy = "effects")
    private Set<Major> majors = new HashSet<>();

    @OneToMany(mappedBy = "effect")
    private Set<SubjectIdeaEffect> subjectIdeaEffects = new HashSet<>();

    @OneToMany(mappedBy = "effect")
    private Set<EffectIdea> effectIdeas = new HashSet<>();

    //pomocnicze do one to many, jak chcemy dodać to dodajemy z dwóch stron i zapisujemy środkową encją
    public void addSubjectIdeaEffect(SubjectIdeaEffect subjectIdeaEffect) {
        subjectIdeaEffects.add(subjectIdeaEffect);
        subjectIdeaEffect.setEffect(this);
    }

    public void removeSubjectIdeaEffect(SubjectIdeaEffect subjectIdeaEffect) {
        subjectIdeaEffects.remove(subjectIdeaEffect);
        subjectIdeaEffect.setEffect(null);
    }
}
