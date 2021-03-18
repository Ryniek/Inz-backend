package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class EffectResponse {
    private Long id;
    private String code;
    private String content;
    private EffectType type;

    public static EffectResponse toResponse(SubjectEffect effect) {
        EffectResponse result = new EffectResponse();
        result.setId(effect.getId());
        result.setCode(effect.getCode());
        result.setContent(effect.getContent());
        result.setType(effect.getType());
        return result;
    }

    public static EffectResponse toResponse(MajorEffect effect) {
        EffectResponse result = new EffectResponse();
        result.setId(effect.getId());
        result.setCode(effect.getCode());
        result.setContent(effect.getContent());
        result.setType(effect.getType());
        return result;
    }
}
