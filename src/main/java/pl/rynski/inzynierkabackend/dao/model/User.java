package pl.rynski.inzynierkabackend.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "VARCHAR(250)")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "register_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime registerTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonBackReference
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private Set<SubjectIdea> subjectIdeas = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ModuleIdea> moduleIdeas = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<EducationalOutcomesIdea> educationalOutcomesIdeas = new HashSet<>();
}
