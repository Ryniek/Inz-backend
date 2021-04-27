package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;

//TODO dodawanie detailsow(oddzielny endpoint)
@Data
public class ModuleSubjectDetailsDto {
    private Integer ects;
    private Integer semester;
    private TypeOfPassing typeOfPassing;
    private Long tutorId;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;

    public static MajorModuleSubjectDetails fromDto(ModuleSubjectDetailsDto dto, MajorModuleSubject majorModuleSubject, Tutor tutor) {
        MajorModuleSubjectDetails result = new MajorModuleSubjectDetails();
        result.setEcts(dto.getEcts());
        result.setSemester(dto.getSemester());
        result.setTypeOfPassing(dto.getTypeOfPassing());
        result.setTutor(tutor);
        tutor.addMajorModuleSubjectDetails(result);
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        majorModuleSubject.addMajorModuleSubjectDetails(result);
        return result;
    }
}
