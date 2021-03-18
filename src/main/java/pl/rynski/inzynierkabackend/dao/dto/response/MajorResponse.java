package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MajorResponse {
    private Long id;
    private String name;
    private StudyType studyType;
    private String years;
    private Boolean hidden;
    private DepartmentResponse department;

    public static MajorResponse toResponse(Major major) {
        MajorResponse result = new MajorResponse();
        result.setId(major.getId());
        result.setName(major.getName());
        result.setStudyType(major.getStudyType());
        result.setYears(major.getYears());
        result.setHidden(major.getHidden());
        result.setDepartment(DepartmentResponse.toResponse(major.getDepartment()));
        return result;
    }
}
