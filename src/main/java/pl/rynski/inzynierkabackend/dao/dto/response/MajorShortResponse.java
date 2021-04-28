package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.enums.StudyType;

@Data
public class MajorShortResponse {
    private Long id;
    private String name;
    private StudyType studyType;
    private String years;

    public static MajorShortResponse toResponse(Major major) {
        MajorShortResponse result = new MajorShortResponse();
        result.setId(major.getId());
        result.setName(major.getName());
        result.setStudyType(major.getStudyType());
        result.setYears(major.getYears());
        return result;
    }
}
