package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;

@Data
public class MajorModuleResponse {
    private Long id;
    //TODO Zamiast moduleResponse to ulozyc swoja wlasny obiekt w ktorym znajdowac się bedzie lista przypisanych przedmiotow
    private ModuleResponse module;
    private TutorResponse tutor;

    public static MajorModuleResponse toResponse(MajorModule majorModule) {
        MajorModuleResponse result = new MajorModuleResponse();
        result.setId(majorModule.getId());
        result.setModule(ModuleResponse.toResponse(majorModule.getModule()));
        result.setTutor(TutorResponse.toResponse(majorModule.getTutor()));
        return result;
    }
}
