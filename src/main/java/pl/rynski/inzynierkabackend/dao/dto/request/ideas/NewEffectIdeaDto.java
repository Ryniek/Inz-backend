package pl.rynski.inzynierkabackend.dao.dto.request.ideas;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.EffectIdea;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;
import pl.rynski.inzynierkabackend.utils.DateUtils;

@Data
public class NewEffectIdeaDto {
    private String content;
    private String ideaExplanation;
    private EffectType type;
    private Long majorId;

    public static EffectIdea fromDto(NewEffectIdeaDto dto, Major major) {
        EffectIdea result = new EffectIdea();
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setContent(dto.getContent());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setType(dto.getType());
        major.addEffectIdea(result);
        return result;
    }
}
