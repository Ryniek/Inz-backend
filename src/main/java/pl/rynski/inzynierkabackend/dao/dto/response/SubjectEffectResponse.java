package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;
import pl.rynski.inzynierkabackend.dao.model.SubjectIdeaEffect;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class SubjectEffectResponse {
    private Long id;
    private String code;
    private String content;
    private EffectType type;
    private Integer connectionStrength;

    public static SubjectEffectResponse toResponse(SubjectEffect subjectEffect) {
        SubjectEffectResponse result = new SubjectEffectResponse();
        result.setId(subjectEffect.getEffect().getId());
        result.setCode(subjectEffect.getEffect().getCode());
        result.setContent(subjectEffect.getEffect().getContent());
        result.setType(subjectEffect.getEffect().getType());
        result.setConnectionStrength(subjectEffect.getConnectionStrength());
        return result;
    }

    public static SubjectEffectResponse toResponse(SubjectIdeaEffect subjectIdeaEffect) {
        SubjectEffectResponse result = new SubjectEffectResponse();
        result.setId(subjectIdeaEffect.getEffect().getId());
        result.setCode(subjectIdeaEffect.getEffect().getCode());
        result.setContent(subjectIdeaEffect.getEffect().getContent());
        result.setType(subjectIdeaEffect.getEffect().getType());
        result.setConnectionStrength(subjectIdeaEffect.getConnectionStrength());
        return result;
    }
}
