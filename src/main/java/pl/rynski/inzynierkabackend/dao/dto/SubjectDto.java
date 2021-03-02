package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Subject;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;

import java.util.HashSet;
import java.util.Set;

@Data
public class SubjectDto {
    private String name;
    private String subjectCode;
    private Set<SubjectEffectDto> effects = new HashSet<>();

    public static Subject fromDto(SubjectDto dto, Set<SubjectEffect> effects) {
        Subject result = new Subject();
        result.setName(dto.getName());
        result.setSubjectCode(dto.getSubjectCode());
        result.setSubjectEffects(effects);
        effects.forEach(effect -> effect.setSubject(result));
        return result;
    }
}
