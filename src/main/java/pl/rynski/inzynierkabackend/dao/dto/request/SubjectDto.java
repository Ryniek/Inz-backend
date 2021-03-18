package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Subject;

import java.util.HashSet;
import java.util.Set;

@Data
public class SubjectDto {
    private String name;
    private String subjectCode;

    public static Subject fromDto(SubjectDto dto) {
        Subject result = new Subject();
        result.setName(dto.getName());
        result.setSubjectCode(dto.getSubjectCode());
        return result;
    }
}
