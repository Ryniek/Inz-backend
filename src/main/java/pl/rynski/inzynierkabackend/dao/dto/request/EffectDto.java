package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.dao.model.MajorModuleSubject;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class EffectDto {
    private String code;
    private String content;
    private EffectType type;

    public static MajorEffect fromDto(EffectDto dto, Major major) {
        MajorEffect result = new MajorEffect();
        result.setCode(dto.getCode());
        result.setContent(dto.getContent());
        result.setType(dto.getType());
        result.addMajor(major);
        return result;
    }

    public static MajorEffect fromDto(EffectDto dto) {
        MajorEffect result = new MajorEffect();
        result.setCode(dto.getCode());
        result.setContent(dto.getContent());
        result.setType(dto.getType());
        return result;
    }

    public static SubjectEffect fromDto(EffectDto dto, MajorModuleSubject majorModuleSubject) {
        SubjectEffect result = new SubjectEffect();
        result.setContent(dto.getContent());
        result.setType(dto.getType());
        majorModuleSubject.addSubjectEffect(result);
        return result;
    }
}
