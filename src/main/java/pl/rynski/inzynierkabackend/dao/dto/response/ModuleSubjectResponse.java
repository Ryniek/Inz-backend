package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModuleSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ModuleSubjectResponse {
    private Long id;
    private Integer ects;
    private Integer semester;
    private MajorShortResponse major;
    private ModuleShortResponse module;
    private SubjectResponse subject;
    private TutorResponse tutor;
    private ContactHoursResponse contactHours;
    private NonContactHoursResponse nonContactHours;


    public static ModuleSubjectResponse toResponse(MajorModuleSubject moduleSubject) {
        ModuleSubjectResponse result = new ModuleSubjectResponse();
        result.setId(moduleSubject.getId());
        result.setEcts(moduleSubject.getEcts());
        result.setSemester(moduleSubject.getSemester());
        result.setMajor(MajorShortResponse.toResponse(moduleSubject.getMajorModule().getMajor()));
        result.setModule(ModuleShortResponse.toResponse(moduleSubject.getMajorModule().getModule()));
        result.setSubject(SubjectResponse.toResponse(moduleSubject.getSubject()));
        result.setTutor(TutorResponse.toResponse(moduleSubject.getTutor()));
        result.setContactHours(ContactHoursResponse.toResponse(moduleSubject.getContactHours()));
        result.setNonContactHours(NonContactHoursResponse.toResponse(moduleSubject.getNonContactHours()));
        return result;
    }
}
