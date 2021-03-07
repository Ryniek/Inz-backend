package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class EffectDto {
    private String code;
    private String content;
    private EffectType type;
    private Boolean forSubject;
    private Boolean forMajor;

    //TODO walidacja czy forSubject i forField sa rozne
    public static Effect fromDto(EffectDto dto) {
        Effect result = new Effect();
        result.setCode(dto.getCode());
        result.setContent(dto.getContent());
        result.setType(dto.getType());
        result.setForSubject(dto.getForSubject());
        result.setForMajor(dto.getForMajor());
        return result;
    }
}
