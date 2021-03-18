package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;
import pl.rynski.inzynierkabackend.dao.model.SubjectIdea;
import pl.rynski.inzynierkabackend.dao.model.Tutor;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.Set;

@Data
public class NewSubjectIdeaDto {
    private String subjectName;
    private String ideaExplanation;
    private String goals;
    private String resources;
    private Integer semester;
    private Integer ects;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;
    private Long majorModuleId;
    private Long tutorId;

    public static SubjectIdea fromDto(NewSubjectIdeaDto dto, MajorModule majorModule, Tutor tutor) {
        SubjectIdea result = new SubjectIdea();
        result.setSubjectName(dto.getSubjectName());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setGoals(dto.getGoals());
        result.setResourcesNeeded(dto.getResources());
        result.setSemester(dto.getSemester());
        result.setEcts(dto.getEcts());
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        result.setSendingTime(DateUtils.getCurrentDateTime());
        if(majorModule != null) majorModule.addSubjectIdea(result);
        tutor.addSubjectIdea(result);
        return result;
    }
}
