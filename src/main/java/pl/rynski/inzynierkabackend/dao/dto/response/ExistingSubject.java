package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.ModuleIdeaSubject;

@Data
public class ExistingSubject {
    private ModuleSubjectResponse subject;
    private Integer semester;

    public static ExistingSubject toResponse(ModuleIdeaSubject moduleIdeaSubject) {
        ExistingSubject result = new ExistingSubject();
        result.setSubject(ModuleSubjectResponse.toResponse(moduleIdeaSubject.getMajorModuleSubject()));
        result.setSemester(moduleIdeaSubject.getSemester());
        return result;
    }
}
