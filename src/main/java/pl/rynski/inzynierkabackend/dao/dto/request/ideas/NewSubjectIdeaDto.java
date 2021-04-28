package pl.rynski.inzynierkabackend.dao.dto.request.ideas;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.dto.request.ContactHoursDto;
import pl.rynski.inzynierkabackend.dao.dto.request.NonContactHoursDto;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;
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
    private TypeOfPassing typeOfPassing;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;
    private Long majorModuleId;
    private Long supervisorId;
    private Long tutorId;
    private Set<MajorEffectIdDto> majorEffects = new HashSet<>();
    private Set<SubjectIdeaEffectDto> subjectEffects = new HashSet<>();

    @Data
    public static class MajorEffectIdDto {
        private Long majorEffectId;
        private Integer connectionStrength;
    }

    @Data
    public static class SubjectIdeaEffectDto {
        private String content;
        private EffectType type;

        public static SubjectEffect fromDto(SubjectIdeaEffectDto dto) {
            SubjectEffect result = new SubjectEffect();
            result.setContent(dto.getContent());
            result.setType(dto.getType());
            return result;
        }
    }

    public static SubjectIdea fromDto(NewSubjectIdeaDto dto, MajorModule majorModule, Tutor supervisor, Tutor tutor, Set<MajorEffectSubjectIdea> majorEffects) {
        SubjectIdea result = new SubjectIdea();
        result.setSubjectName(dto.getSubjectName());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setGoals(dto.getGoals());
        result.setResourcesNeeded(dto.getResources());
        result.setSemester(dto.getSemester());
        result.setEcts(dto.getEcts());
        result.setTypeOfPassing(dto.getTypeOfPassing());
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        result.setSendingTime(DateUtils.getCurrentDateTime());
        if(majorModule != null) majorModule.addSubjectIdea(result);
        supervisor.addSubjectIdeaSupervisor(result);
        tutor.addSubjectIdea(result);
        if(!majorEffects.isEmpty()) {
            result.setMajorEffectSubjectIdeas(majorEffects);
        }
        if(!dto.getSubjectEffects().isEmpty()) {
            dto.getSubjectEffects().stream()
                    .forEach(subjectEffect ->
                            result.addSubjectEffect(SubjectIdeaEffectDto.fromDto(subjectEffect)));
        }
        return result;
    }
}
