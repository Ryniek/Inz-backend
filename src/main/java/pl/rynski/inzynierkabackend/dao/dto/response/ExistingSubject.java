package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.ModuleIdeaExistingSubject;

@Data
public class ExistingSubject {
    private SubjectResponse subject;
    private TutorResponse tutor;
    private Integer ects;

    public static ExistingSubject toResponse(ModuleIdeaExistingSubject moduleIdeaExistingSubject) {
        ExistingSubject result = new ExistingSubject();
        result.setSubject(SubjectResponse.toResponse(moduleIdeaExistingSubject.getSubject()));
        result.setTutor(TutorResponse.toResponse(moduleIdeaExistingSubject.getTutor()));
        result.setEcts(moduleIdeaExistingSubject.getEcts());
        return result;
    }
}
