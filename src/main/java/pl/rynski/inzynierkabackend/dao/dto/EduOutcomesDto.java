package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.enums.EducationalOutcomesType;

@Data
public class EduOutcomesDto {
    private String code;
    private String content;
    private EducationalOutcomesType type;
    private Boolean forSubject;
    private Boolean forField;

    //TODO walidacja czy forSubject i forField sa rozne
}
