package pl.rynski.inzynierkabackend.dao.dto.request.ideas;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.dto.request.MajorEffectConnectionDto;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.Set;

@Data
public class ChangeEffectIdeaDto {
    private String content;
    private String ideaExplanation;
    private Set<MajorEffectConnectionDto> majorEffectSubjects = new HashSet<>();

    public static EffectIdea fromDto(ChangeEffectIdeaDto dto, MajorEffect majorEffect, Set<EffectIdeaModuleSubject> effectSubjects) {
        EffectIdea result = new EffectIdea();
        result.setExisting(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setContent(dto.getContent());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        majorEffect.addEffectIdea(result);
        if(!effectSubjects.isEmpty()) {
            result.setEffectIdeaModuleSubject(effectSubjects);
            effectSubjects.forEach(effectIdeaSubject -> effectIdeaSubject.setEffectIdea(result));
        }
        return result;
    }
}
