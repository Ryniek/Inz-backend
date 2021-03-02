package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;

import java.util.HashSet;
import java.util.Set;

@Data
public class ModuleSubjectDto {
    private Integer ects;
    private Integer semester;
    private Long subjectId;
    private Long tutorId;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;

    public static MajorModuleSubject fromDto(ModuleSubjectDto dto, MajorModule majorModule, Subject subject, Tutor tutor) {
        MajorModuleSubject result = new MajorModuleSubject();
        result.setEcts(dto.getEcts());
        result.setSemester(dto.getSemester());
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        majorModule.addMajorModuleSubject(result);
        subject.addMajorModuleSubject(result);
        tutor.addMajorModuleSubject(result);
        return result;
    }
}
