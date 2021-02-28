package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.dto.DepartmentDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(250)")
    private String name;

    @OneToMany(mappedBy = "department", orphanRemoval = true)
    private Set<Major> majors = new HashSet<>();

    public Department(String name) {
        this.name = name;
    }
}
