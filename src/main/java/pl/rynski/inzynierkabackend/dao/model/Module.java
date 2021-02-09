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

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(250)")
    private String name;

    @Column(name = "specialized")
    private Boolean specialized;

    @OneToMany(mappedBy = "module")
    private Set<FieldModule> fieldModules = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "module_subject",
            joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private Set<Subject> subjects = new HashSet<>();

    //pomocnicze
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getModules().add(this);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
        subject.getModules().remove(this);
    }
}
