package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Subject;

@Data
public class SubjectResponse {
    private Long id;
    private String name;
    private String subjectCode;

    public static SubjectResponse toResponse(Subject subject) {
        SubjectResponse result = new SubjectResponse();
        result.setId(subject.getId());
        result.setName(subject.getName());
        result.setSubjectCode(subject.getSubjectCode());
        return result;
    }
}
