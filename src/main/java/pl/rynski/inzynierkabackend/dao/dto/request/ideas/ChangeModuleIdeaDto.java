package pl.rynski.inzynierkabackend.dao.dto.request.ideas;

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
    private Set<NewModuleIdeaDto.NewSubject> newSubjects = new HashSet<>();
    private Set<NewModuleIdeaDto.ExistingSubject> existingSubjects = new HashSet<>();

    public static ModuleIdea fromDto(ChangeModuleIdeaDto dto, MajorModule majorModule, Tutor tutor, Set<ModuleIdeaNewSubject> newSubjects,  Set<ModuleIdeaExistingSubject> existingSubjects) {
        ModuleIdea result = new ModuleIdea();
        result.setExisting(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        majorModule.addModuleIdea(result);
        if(tutor != null) tutor.addModuleIdea(result);
        if(!newSubjects.isEmpty()) {
            newSubjects.forEach(result::addNewSubject);
        }
        if(!existingSubjects.isEmpty()) {
            existingSubjects.forEach(result::addExistingSubject);
        }
        return result;
    }
}
