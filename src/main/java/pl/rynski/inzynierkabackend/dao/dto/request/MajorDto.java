package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Department;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
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
    private List<Long> majorEffects = new ArrayList<>();
    private List<EffectDto> newMajorEffects = new ArrayList<>();

    public static Major fromDto(MajorDto dto, Department department, List<MajorEffect> majorEffects) {
        Major major = new Major();
        major.setName(dto.getName());
        major.setStudyType(dto.getStudyType());
        major.setYears(dto.getYears());
        major.setHidden(dto.getHidden());
        major.setDepartment(department);
        if(!majorEffects.isEmpty()) major.setMajorEffects(new HashSet<>(majorEffects));
        return major;
    }
}
