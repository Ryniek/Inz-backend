package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Module;

@Data
public class ModuleShortResponse {
    private Long id;
    private String name;
    private Boolean specialized;

    public static ModuleShortResponse toResponse(Module module) {
        ModuleShortResponse result = new ModuleShortResponse();
        result.setId(module.getId());
        result.setName(module.getName());
        result.setSpecialized(module.getSpecialized());
        return result;
    }
}
