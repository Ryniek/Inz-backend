package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;

@Data
public class SubjectEffectDto {
    private Long id;
    private Integer connectionStrength;

    public static SubjectEffect fromDto(SubjectEffectDto dto, Effect effect) {
        SubjectEffect result = new SubjectEffect();
        result.setEffect(effect);
        result.setConnectionStrength(dto.getConnectionStrength());
        return result;
    }
}
