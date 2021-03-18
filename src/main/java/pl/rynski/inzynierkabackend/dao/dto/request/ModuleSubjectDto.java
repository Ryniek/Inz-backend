package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;

@Data
public class ModuleSubjectDto {
    private Integer ects;
    private Integer semester;
    private TypeOfPassing typeOfPassing;
    private Long subjectId;
    private Long supervisorId;
    private Long tutorId;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;

    public static MajorModuleSubject fromDto(ModuleSubjectDto dto, MajorModule majorModule, Subject subject, Tutor supervisor, Tutor tutor) {
        MajorModuleSubject result = new MajorModuleSubject();
        result.setEcts(dto.getEcts());
        result.setSemester(dto.getSemester());
        result.setTypeOfPassing(dto.getTypeOfPassing());
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        majorModule.addMajorModuleSubject(result);
        subject.addMajorModuleSubject(result);
        supervisor.addMajorModuleSubjectSupervisor(result);
        tutor.addMajorModuleSubject(result);
        return result;
    }
}
