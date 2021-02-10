package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ModuleResponse {
    private Long id;
    private String name;
    private Boolean specialized;
    private List<SubjectResponse> subjects = new ArrayList<>();

    public static ModuleResponse toResponse(Module module) {
        ModuleResponse result = new ModuleResponse();
        result.setId(module.getId());
        result.setName(module.getName());
        result.setSpecialized(module.getSpecialized());
        result.setSubjects(module.getSubjects().stream().map(SubjectResponse::toResponse).collect(Collectors.toList()));
        return result;
    }
}
