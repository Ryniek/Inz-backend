package pl.rynski.inzynierkabackend.dao.dto.response;

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
    private Boolean forMajor;

    public static EffectResponse toResponse(Effect effect) {
        EffectResponse result = new EffectResponse();
        result.setId(effect.getId());
        result.setCode(effect.getCode());
        result.setContent(effect.getContent());
        result.setType(effect.getType());
        result.setForSubject(effect.getForSubject());
        result.setForMajor(effect.getForMajor());
        return result;
    }
}
