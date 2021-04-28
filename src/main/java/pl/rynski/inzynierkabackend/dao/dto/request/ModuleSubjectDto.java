package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ModuleSubjectDto {
    private Long subjectId;
    private Long supervisorId;
    private List<MajorEffectConnectionDto> majorEffects = new ArrayList<>();
    private List<EffectDto> subjectEffects = new ArrayList<>();

    public static MajorModuleSubject fromDto(ModuleSubjectDto dto, MajorModule majorModule, Subject subject, Tutor supervisor, Set<MajorEffectModuleSubject> majorEffects) {
        MajorModuleSubject result = new MajorModuleSubject();
        majorModule.addMajorModuleSubject(result);
        subject.addMajorModuleSubject(result);
        supervisor.addMajorModuleSubjectSupervisor(result);
        result.setMajorEffects(majorEffects);
        dto.getSubjectEffects().stream()
                .forEach(subjectEffect -> result.addSubjectEffect(EffectDto.fromDtoWithoutCode(subjectEffect)));
        return result;
    }
}
