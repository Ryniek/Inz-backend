package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModuleSubjectDetails;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;

@Data
public class ModuleSubjectDetailsResponse {
    private Long id;
    private Integer ects;
    private Integer semester;
    private TypeOfPassing typeOfPassing;
    private TutorResponse tutor;
    private ContactHoursResponse contactHours;
    private NonContactHoursResponse nonContactHours;

    public static ModuleSubjectDetailsResponse toResponse(MajorModuleSubjectDetails details) {
        ModuleSubjectDetailsResponse result = new ModuleSubjectDetailsResponse();
        result.setId(details.getId());
        result.setEcts(details.getEcts());
        result.setSemester(details.getSemester());
        result.setTypeOfPassing(details.getTypeOfPassing());
        result.setTutor(TutorResponse.toResponse(details.getTutor()));
        if(details.getContactHours() != null) result.setContactHours(ContactHoursResponse.toResponse(details.getContactHours()));
        if(details.getNonContactHours() != null) result.setNonContactHours(NonContactHoursResponse.toResponse(details.getNonContactHours()));
        return result;
    }
}
