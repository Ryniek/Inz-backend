package pl.rynski.inzynierkabackend.dao.dto.request.ideas;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.utils.DateUtils;

@Data
public class DeleteIdeaDto {
    private Long effectId;
    private String ideaExplanation;

    public static ModuleIdea fromDto(DeleteIdeaDto dto, MajorModule majorModule) {
        ModuleIdea result = new ModuleIdea();
        result.setExisting(true);
        result.setToRemove(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        majorModule.addModuleIdea(result);
        return result;
    }

    public static SubjectIdea fromDto(DeleteIdeaDto dto, MajorModuleSubject majorModuleSubject) {
        SubjectIdea result = new SubjectIdea();
        result.setExisting(true);
        result.setToRemove(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        majorModuleSubject.addSubjectIdea(result);
        return result;
    }

    public static EffectIdea fromDto(DeleteIdeaDto dto, MajorEffect majorEffect) {
        EffectIdea result = new EffectIdea();
        result.setExisting(true);
        result.setToRemove(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        majorEffect.addEffectIdea(result);
        return result;
    }
}
