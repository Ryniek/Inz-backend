package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorEffectModuleSubject;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class MajorEffectResponse {
    private Long id;
    private String code;
    private String content;
    private EffectType type;
    private Integer connectionStrength;

    public static MajorEffectResponse toResponse(MajorEffectModuleSubject majorEffect) {
        MajorEffectResponse result = new MajorEffectResponse();
        result.setId(majorEffect.getMajorEffect().getId());
        result.setCode(majorEffect.getMajorEffect().getCode());
        result.setContent(majorEffect.getMajorEffect().getContent());
        result.setType(majorEffect.getMajorEffect().getType());
        result.setConnectionStrength(majorEffect.getConnectionStrength());
        return result;
    }
}
