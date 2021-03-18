package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.dao.model.MajorEffectSubject;
import pl.rynski.inzynierkabackend.dao.model.Subject;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;

import java.util.HashSet;
import java.util.Set;

@Data
public class SubjectDto {
    private String name;
    private String subjectCode;
    private Set<MajorEffectDto> majorEffects = new HashSet<>();
    private Set<Long> subjectEffects = new HashSet<>();

    @Data
    public static class MajorEffectDto {
        private Long majorEffectId;
        private Integer connectionStrength;
    }

    public static Subject fromDto(SubjectDto dto, Set<MajorEffectSubject> majorEffects, Set<SubjectEffect> subjectEffects) {
        Subject result = new Subject();
        result.setName(dto.getName());
        result.setSubjectCode(dto.getSubjectCode());
        result.setMajorEffects(majorEffects);
        result.setSubjectEffects(subjectEffects);
        return result;
    }
}
