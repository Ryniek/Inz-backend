package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.Set;

@Data
public class ChangeModuleIdeaDto {
    private String ideaExplanation;
    private Long tutorId;
    //TODO walidacja ze max 8 w obu listach ponizej lacznie
    private Set<NewSubjectIdeaDto> newSubjects = new HashSet<>();
    private Set<NewModuleIdeaDto.ExistingSubject> existingSubjects = new HashSet<>();

    public static ModuleIdea fromDto(ChangeModuleIdeaDto dto, MajorModule majorModule, Tutor tutor,  Set<SubjectIdea> subjectIdeas, Set<ModuleIdeaSubject> existingSubjects) {
        ModuleIdea result = new ModuleIdea();
        result.setExisting(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        majorModule.addModuleIdea(result);
        if(tutor != null) tutor.addModuleIdea(result);
        if(!subjectIdeas.isEmpty()) {
            result.setSubjectIdeas(subjectIdeas);
            subjectIdeas.forEach(subjectIdea -> subjectIdea.setModuleIdea(result));
        }
        if(!existingSubjects.isEmpty()) {
            result.setModuleIdeaSubjects(existingSubjects);
            existingSubjects.forEach(effect -> effect.setModuleIdea(result));
        }
        return result;
    }
}
