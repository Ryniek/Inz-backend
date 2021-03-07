package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;
import pl.rynski.inzynierkabackend.dao.model.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MajorModuleResponse {
    private Long id;
    private ModuleShortResponse module;
    private TutorResponse tutor;
    private List<ModuleSubjectResponse> subjects = new ArrayList<>();

    public static MajorModuleResponse toResponse(MajorModule majorModule) {
        MajorModuleResponse result = new MajorModuleResponse();
        result.setId(majorModule.getId());
        result.setModule(ModuleShortResponse.toResponse(majorModule.getModule()));
        result.setTutor(TutorResponse.toResponse(majorModule.getTutor()));
        result.setSubjects(majorModule
                .getMajorModuleSubjects().stream()
                .map(ModuleSubjectResponse::toResponse)
                .collect(Collectors.toList()));
        return result;
    }
}
