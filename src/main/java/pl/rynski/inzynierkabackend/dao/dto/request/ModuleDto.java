package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Module;

@Data
public class ModuleDto {
    private String name;
    private Boolean specialized;

    public static Module fromDto(ModuleDto dto) {
        Module module = new Module();
        module.setName(dto.getName());
        module.setSpecialized(dto.getSpecialized());
        return module;
    }
}
