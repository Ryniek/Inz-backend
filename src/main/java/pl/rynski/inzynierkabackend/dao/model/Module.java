package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "specialized")
    private Boolean specialized;

    @OneToMany(mappedBy = "module")
    private Set<MajorModule> majorModules = new HashSet<>();

    //TODO Tutaj też rozważyć EAGER
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "module_subject",
            joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private Set<Subject> subjects = new HashSet<>();

    //pomocnicze do Many to Many - dajemy gdzie chcemy ale zapisujemy przez zarzadzajaca
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getModules().add(this);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
        subject.getModules().remove(this);
    }

    //pomocnicze dajemy tam gdzie one to many
    public void addMajorModule(MajorModule majorModule) {
        majorModules.add(majorModule);
        majorModule.setModule(this);
    }

    public void removeMajorModule(MajorModule majorModule) {
        majorModules.remove(majorModule);
        majorModule.setModule(null);
    }
}
