package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Department;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Data
public class MajorDto {
    private String name;
    private StudyType studyType;
    private String years;
    private Boolean hidden;
    private Long departmentId;
    private List<Long> effects = new ArrayList<>();

    public static Major fromDto(MajorDto dto, Department department, List<Effect> effects) {
        Major major = new Major();
        major.setName(dto.getName());
        major.setStudyType(dto.getStudyType());
        major.setYears(dto.getYears());
        major.setHidden(dto.getHidden());
        major.setDepartment(department);
        major.setEffects(new HashSet<>(effects));
        return major;
    }
}
