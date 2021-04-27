package pl.rynski.inzynierkabackend.dao.dto.request.ideas;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.dto.request.ContactHoursDto;
import pl.rynski.inzynierkabackend.dao.dto.request.NonContactHoursDto;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;
import pl.rynski.inzynierkabackend.utils.DateUtils;

@Data
public class ChangeSubjectIdeaDto {
    private String ideaExplanation;
    private Integer semester;
    private Integer ects;
    private TypeOfPassing typeOfPassing;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;
    //Propozycja przypisania przedmiotu do innego modułu
    private Long majorModuleId;
    //Propozycja zmiany kierownika przedmiotu
    private Long supervisorId;
    //Propozycja zmiany prowadzącego
    private Long tutorId;

    public static SubjectIdea fromDto(ChangeSubjectIdeaDto dto, MajorModuleSubject majorModuleSubject, MajorModule majorModule, Tutor supervisor, Tutor tutor) {
        SubjectIdea result = new SubjectIdea();
        result.setExisting(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setSemester(dto.getSemester());
        result.setEcts(dto.getEcts());
        result.setTypeOfPassing(dto.getTypeOfPassing());
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        if(majorModule != null) majorModule.addSubjectIdea(result);
        if(tutor != null) tutor.addSubjectIdea(result);
        if(supervisor != null) supervisor.addSubjectIdeaSupervisor(result);
        majorModuleSubject.addSubjectIdea(result);
        return result;
    }
}
