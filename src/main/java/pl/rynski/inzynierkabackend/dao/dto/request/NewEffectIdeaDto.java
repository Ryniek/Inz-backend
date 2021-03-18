package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.EffectIdea;
import pl.rynski.inzynierkabackend.dao.model.EffectIdeaSubject;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.Subject;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class NewEffectIdeaDto {
    private String content;
    private String ideaExplanation;
    private EffectType type;
    private Long subjectId;
    private Long majorId;
    private Boolean forSubject;
    private Boolean forMajor;
    private Set<MajorEffectSubjectDto> majorEffectSubjects = new HashSet<>();

    @Data
    public static class MajorEffectSubjectDto {
        private Long subjectId;
        private Integer connectionStrength;
    }

    public static EffectIdea fromDto(NewEffectIdeaDto dto, Subject subject, Major major, Set<EffectIdeaSubject> effectSubjects) {
        EffectIdea result = new EffectIdea();
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setContent(dto.getContent());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setType(dto.getType());
        result.setForSubject(dto.getForSubject());
        result.setForMajor(dto.getForMajor());
        if(subject != null) result.setSubject(subject);
        if(major != null) result.setMajor(major);
        if(!effectSubjects.isEmpty()) {
            result.setEffectIdeaSubject(effectSubjects);
            effectSubjects.forEach(effectIdeaSubject -> effectIdeaSubject.setEffectIdea(result));
        }
        return result;
    }
}
