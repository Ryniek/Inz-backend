package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class EffectResponse {
    private Long id;
    private String code;
    private String content;
    private EffectType type;
    private Boolean forSubject;
    private Boolean forField;

    public static EffectResponse toResponse(Effect outcomes) {
        EffectResponse result = new EffectResponse();
        result.setId(outcomes.getId());
        result.setCode(outcomes.getCode());
        result.setContent(outcomes.getContent());
        result.setType(outcomes.getType());
        result.setForSubject(outcomes.getForSubject());
        result.setForField(outcomes.getForMajor());
        return result;
    }
}
