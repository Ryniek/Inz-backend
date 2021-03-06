package pl.rynski.inzynierkabackend.dao.dto.request.ideas;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.Set;

@Data
public class NewModuleIdeaDto {
    private String moduleName;
    private String ideaExplanation;
    private String graduateSkills;
    private String potentialEmployers;
    private Long tutorId;
    private Long majorId;
    //TODO walidacja ze max 8 w obu listach ponizej lacznie
    //majorModuleId tutaj musi byc null
    private Set<NewSubjectIdeaDto> newSubjects = new HashSet<>();
    private Set<ExistingSubject> existingSubjects = new HashSet<>();

    @Data
    public static class ExistingSubject {
        private Long subjectId;
        private Long tutorId;
        private Integer ects;
    }

    public static ModuleIdea fromDto(NewModuleIdeaDto dto, Tutor tutor, Major major, Set<SubjectIdea> subjectIdeas, Set<ModuleIdeaSubject> existingSubjects) {
        ModuleIdea result = new ModuleIdea();
        result.setModuleName(dto.getModuleName());
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setGraduateSkills(dto.getGraduateSkills());
        result.setPotentialEmployers(dto.getPotentialEmployers());
        result.setMajor(major);
        tutor.addModuleIdea(result);
        if(!subjectIdeas.isEmpty()) {
            result.setSubjectIdeas(subjectIdeas);
            subjectIdeas.forEach(subjectIdea -> subjectIdea.setModuleIdea(result));
        }
        //TODO tu sprawdzic czy not null i zrobic ta posredniczaca
        if(!existingSubjects.isEmpty()) {
            result.setModuleIdeaSubjects(existingSubjects);
            existingSubjects.forEach(effect -> effect.setModuleIdea(result));
        }
        return result;
    }
}
