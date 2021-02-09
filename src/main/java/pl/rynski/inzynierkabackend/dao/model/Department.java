package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import pl.rynski.inzynierkabackend.dao.dto.DepartmentDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(250)")
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<FieldOfStudy> fieldOfStudies = new HashSet<>();

    public static Department fromDto(DepartmentDto dto) {
        Department result = new Department();
        result.setName(dto.getName());
        return result;
    }
}
