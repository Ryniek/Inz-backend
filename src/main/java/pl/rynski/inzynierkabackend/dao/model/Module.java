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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_of_study_id", referencedColumnName = "id")
    private FieldOfStudy fieldOfStudy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @OneToMany(mappedBy = "module")
    private Set<Subject> subjects = new HashSet<>();
}
