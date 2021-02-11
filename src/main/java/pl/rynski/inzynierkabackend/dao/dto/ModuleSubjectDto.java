package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;

import java.util.HashSet;
import java.util.Set;

@Data
public class ModuleSubjectDto {
    private Integer ects;
    private Integer semester;
    private Long subjectId;
    private Long tutorId;
    private ContactHoursDto contactHours;
    private NonContactHoursDto nonContactHours;
    private Set<SubjectEffectDto> effects = new HashSet<>();

    public static MajorModuleSubject fromDto(ModuleSubjectDto dto, MajorModule majorModule, Subject subject, Tutor tutor, Set<MajorSubjectEffect> effects) {
        MajorModuleSubject result = new MajorModuleSubject();
        result.setEcts(dto.getEcts());
        result.setSemester(dto.getSemester());
        result.setContactHours(ContactHoursDto.fromDto(dto.getContactHours()));
        result.setNonContactHours(NonContactHoursDto.fromDto(dto.getNonContactHours()));
        majorModule.addMajorModuleSubject(result);
        subject.addMajorModuleSubject(result);
        tutor.addMajorModuleSubject(result);
        result.setMajorSubjectEffects(effects);
        effects.forEach(effect -> effect.setMajorModuleSubject(result));
        return result;
    }
}
