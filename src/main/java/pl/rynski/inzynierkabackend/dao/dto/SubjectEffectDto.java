package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.MajorSubjectEffect;

@Data
public class SubjectEffectDto {
    private Long id;
    private Integer connectionStrength;

    public static MajorSubjectEffect fromDto(SubjectEffectDto dto, Effect effect) {
        MajorSubjectEffect result = new MajorSubjectEffect();
        result.setEffect(effect);
        result.setConnectionStrength(dto.getConnectionStrength());
        return result;
    }
}
