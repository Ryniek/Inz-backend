package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;

@Data
public class ModuleSubjectDto {
    private Integer ects;
    private Integer semester;
    private Long subjectId;
    private Long tutorId;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;
    //TODO + efekty
}
