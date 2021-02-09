package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.EducationalOutcomes;
import pl.rynski.inzynierkabackend.dao.model.enums.EducationalOutcomesType;

@Data
public class EduOutcomesResponse {
    private Long id;
    private String code;
    private String content;
    private EducationalOutcomesType type;
    private Boolean forSubject;
    private Boolean forField;

    public static EduOutcomesResponse toResponse(EducationalOutcomes outcomes) {
        EduOutcomesResponse result = new EduOutcomesResponse();
        result.setId(outcomes.getId());
        result.setCode(outcomes.getCode());
        result.setContent(outcomes.getContent());
        result.setType(outcomes.getType());
        result.setForSubject(outcomes.getForSubject());
        result.setForField(outcomes.getForField());
        return result;
    }
}
