package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
