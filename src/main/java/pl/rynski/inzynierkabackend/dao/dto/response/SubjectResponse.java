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
    private List<SubjectEffectResponse> effects = new ArrayList<>();

    public static SubjectResponse toResponse(Subject subject) {
        SubjectResponse result = new SubjectResponse();
        result.setId(subject.getId());
        result.setName(subject.getName());
        result.setSubjectCode(subject.getSubjectCode());
        result.setEffects(subject
                .getSubjectEffects().stream()
                .map(SubjectEffectResponse::toResponse)
                .collect(Collectors.toList()));
        return result;
    }
}
