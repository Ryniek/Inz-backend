package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorSubjectEffect;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class SubjectEffectResponse {
    private Long id;
    private String code;
    private String content;
    private EffectType type;
    private Integer connectionStrength;

    public static SubjectEffectResponse toResponse(MajorSubjectEffect majorSubjectEffect) {
        SubjectEffectResponse result = new SubjectEffectResponse();
        result.setId(majorSubjectEffect.getEffect().getId());
        result.setCode(majorSubjectEffect.getEffect().getCode());
        result.setContent(majorSubjectEffect.getEffect().getContent());
        result.setType(majorSubjectEffect.getEffect().getType());
        result.setConnectionStrength(majorSubjectEffect.getConnectionStrength());
        return result;
    }
}
