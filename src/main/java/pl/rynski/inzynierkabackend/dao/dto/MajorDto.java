package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;

import java.util.ArrayList;
import java.util.List;

@Data
public class MajorDto {
    private String name;
    private StudyType studyType;
    private String years;
    private Boolean hidden;
    private Long departmentId;
    private List<Long> effects = new ArrayList<>();
}
