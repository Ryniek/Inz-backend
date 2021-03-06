package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorEffectModuleSubject;
import pl.rynski.inzynierkabackend.dao.model.Subject;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;

import java.util.HashSet;
import java.util.Set;

@Data
public class SubjectDto {
    private String name;
    private String subjectCode;

    @Data
    public static class MajorEffectIdDto {
        private Long majorEffectId;
        private Integer connectionStrength;
    }

    public static Subject fromDto(SubjectDto dto) {
        Subject result = new Subject();
        result.setName(dto.getName());
        result.setSubjectCode(dto.getSubjectCode());
        return result;
    }
}
