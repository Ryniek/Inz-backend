package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ModuleSubjectDto {
    private Integer ects;
    private Integer semester;
    private Long subjectId;
    private Long tutorId;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;
    private List<SubjectEffectDto> effects = new ArrayList<>();

    public static MajorModuleSubject fromDto(ModuleSubjectDto dto, Subject subject, Tutor tutor, Set<MajorSubjectEffect> effects) {
        MajorModuleSubject result = new MajorModuleSubject();
        result.setEcts(dto.getEcts());
        result.setSemester(dto.getSemester());
        result.setSubject(subject);
        result.setTutor(tutor);
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        result.setMajorSubjectEffects(effects);
        effects.forEach(effect -> effect.setMajorModuleSubject(result));
        return result;
    }
}
