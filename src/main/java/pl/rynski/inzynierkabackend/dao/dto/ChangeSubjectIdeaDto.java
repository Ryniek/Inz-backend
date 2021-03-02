package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.Set;

@Data
public class ChangeSubjectIdeaDto {
    private String ideaExplanation;
    private Integer semester;
    private Integer ects;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;
    //Propozycja przypisania przedmiotu do innego modułu
    private Long majorModuleId;
    //Propozycja zmiany prowadzącego
    private Long tutorId;

    public static SubjectIdea fromDto(ChangeSubjectIdeaDto dto, MajorModuleSubject majorModuleSubject, MajorModule majorModule, Tutor tutor) {
        SubjectIdea result = new SubjectIdea();
        result.setExisting(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setSemester(dto.getSemester());
        result.setEcts(dto.getEcts());
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        if(majorModule != null) majorModule.addSubjectIdea(result);
        if(tutor != null) tutor.addSubjectIdea(result);
        majorModuleSubject.addSubjectIdea(result);
        return result;
    }
}
