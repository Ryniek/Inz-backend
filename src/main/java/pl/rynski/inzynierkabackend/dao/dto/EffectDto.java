package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

@Data
public class EffectDto {
    private String code;
    private String content;
    private EffectType type;
    private Boolean forSubject;
    private Boolean forField;

    //TODO walidacja czy forSubject i forField sa rozne
}
