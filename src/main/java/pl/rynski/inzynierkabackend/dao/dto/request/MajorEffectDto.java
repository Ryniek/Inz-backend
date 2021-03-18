package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class MajorEffectDto {
    private String code;
    private String content;
    private EffectType type;

    public static MajorEffect fromDto(MajorEffectDto dto, Major major) {
        MajorEffect result = new MajorEffect();
        result.setCode(dto.getCode());
        result.setContent(dto.getContent());
        result.setType(dto.getType());
        result.addMajor(major);
        return result;
    }
}
