package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class SubjectEffectDto {
    private String code;
    private String content;
    private EffectType type;
    private List<Long> majorEffects = new ArrayList();

    public static SubjectEffect fromDto(SubjectEffectDto dto, Set<MajorEffect> majorEffects) {
        SubjectEffect result = new SubjectEffect();
        result.setCode(dto.getCode());
        result.setContent(dto.getContent());
        result.setType(dto.getType());
        result.setMajorEffects(majorEffects);
        return result;
    }

}
