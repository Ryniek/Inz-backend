package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Subject;

@Data
public class SubjectShortResponse {
    private Long id;
    private String name;
    private String subjectCode;

    public static SubjectShortResponse toResponse(Subject subject) {
        SubjectShortResponse result = new SubjectShortResponse();
        result.setId(subject.getId());
        result.setName(subject.getName());
        result.setSubjectCode(subject.getSubjectCode());
        return result;
    }
}
