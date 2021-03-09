package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.ModuleIdeaSubject;

@Data
public class ExistingSubject {
    private SubjectResponse subject;
    private TutorResponse tutor;
    private Integer ects;

    public static ExistingSubject toResponse(ModuleIdeaSubject moduleIdeaSubject) {
        ExistingSubject result = new ExistingSubject();
        result.setSubject(SubjectResponse.toResponse(moduleIdeaSubject.getSubject()));
        result.setTutor(TutorResponse.toResponse(moduleIdeaSubject.getTutor()));
        result.setEcts(moduleIdeaSubject.getEcts());
        return result;
    }
}
