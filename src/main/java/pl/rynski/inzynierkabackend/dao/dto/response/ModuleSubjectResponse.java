package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModuleSubject;
import pl.rynski.inzynierkabackend.dao.model.enums.TypeOfPassing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ModuleSubjectResponse {
    private Long id;
    private MajorShortResponse major;
    private ModuleShortResponse module;
    private SubjectResponse subject;
    private TutorResponse supervisor;
    private List<ModuleSubjectDetailsResponse> moduleSubjectDetails = new ArrayList<>();
    private List<EffectResponse> subjectEffects = new ArrayList<>();
    private List<MajorEffectResponse> majorEffects = new ArrayList<>();

    public static ModuleSubjectResponse toResponse(MajorModuleSubject moduleSubject) {
        ModuleSubjectResponse result = new ModuleSubjectResponse();
        result.setId(moduleSubject.getId());
        result.setMajor(MajorShortResponse.toResponse(moduleSubject.getMajorModule().getMajor()));
        result.setModule(ModuleShortResponse.toResponse(moduleSubject.getMajorModule().getModule()));
        result.setSubject(SubjectResponse.toResponse(moduleSubject.getSubject()));
        result.setSupervisor(TutorResponse.toResponse(moduleSubject.getSupervisor()));
        result.setModuleSubjectDetails(moduleSubject
                .getMajorModuleSubjectDetails().stream()
                .map(ModuleSubjectDetailsResponse::toResponse)
                .collect(Collectors.toList()));
        result.setSubjectEffects(moduleSubject
                .getSubjectEffects().stream()
                .map(EffectResponse::toResponse)
                .collect(Collectors.toList()));
        result.setMajorEffects(moduleSubject
                .getMajorEffects().stream()
                .map(MajorEffectResponse::toResponse)
                .collect(Collectors.toList()));
        return result;
    }
}
