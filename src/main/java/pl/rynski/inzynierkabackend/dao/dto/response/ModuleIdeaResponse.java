package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;
import pl.rynski.inzynierkabackend.dao.model.ModuleIdea;
import pl.rynski.inzynierkabackend.dao.model.ModuleIdeaSubject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ModuleIdeaResponse {
    private Long id;
    private Boolean existing;
    private Boolean approved;
    private Boolean toRemove;
    private LocalDateTime sendingTime;
    private String moduleName;
    private String ideaExplanation;
    private String graduateSkills;
    private String potentialEmployers;
    private MajorShortResponse major;
    private UserResponse user;
    private TutorResponse tutor;
    private MajorModuleResponse majorModule;
    private List<SubjectIdeaResponse> newSubjects = new ArrayList<>();
    private List<ExistingSubject> existingSubjects = new ArrayList<>();

    @Data
    private static class MajorModuleResponse {
        private Long id;
        private MajorShortResponse major;
        private String moduleName;
        private Boolean specialized;
        private TutorResponse tutor;
        private List<ModuleSubjectResponse> subjects = new ArrayList<>();

        private static MajorModuleResponse toResponse(MajorModule majorModule) {
            MajorModuleResponse result = new MajorModuleResponse();
            result.setId(majorModule.getId());
            result.setMajor(MajorShortResponse.toResponse(majorModule.getMajor()));
            result.setModuleName(majorModule.getModule().getName());
            result.setSpecialized(majorModule.getModule().getSpecialized());
            result.setTutor(TutorResponse.toResponse(majorModule.getTutor()));
            result.setSubjects(majorModule
                    .getMajorModuleSubjects().stream()
                    .map(ModuleSubjectResponse::toResponse)
                    .collect(Collectors.toList()));
            return result;
        }
    }

    public static ModuleIdeaResponse toResponse(ModuleIdea moduleIdea) {
        ModuleIdeaResponse result = new ModuleIdeaResponse();
        result.setId(moduleIdea.getId());
        result.setExisting(moduleIdea.getExisting());
        result.setApproved(moduleIdea.getApproved());
        result.setToRemove(moduleIdea.getToRemove());
        result.setSendingTime(moduleIdea.getSendingTime());
        result.setModuleName(moduleIdea.getModuleName());
        result.setIdeaExplanation(moduleIdea.getIdeaExplanation());
        result.setGraduateSkills(moduleIdea.getGraduateSkills());
        result.setPotentialEmployers(moduleIdea.getPotentialEmployers());
        result.setUser(UserResponse.toResponse(moduleIdea.getUser()));
        if(moduleIdea.getMajor() != null) result.setMajor(MajorShortResponse.toResponse(moduleIdea.getMajor()));
        if(moduleIdea.getTutor() != null) result.setTutor(TutorResponse.toResponse(moduleIdea.getTutor()));
        if(moduleIdea.getMajorModule() != null) result.setMajorModule(MajorModuleResponse.toResponse(moduleIdea.getMajorModule()));
        result.setNewSubjects(moduleIdea
                .getSubjectIdeas().stream()
                .map(SubjectIdeaResponse::toResponse)
                .collect(Collectors.toList()));
        result.setExistingSubjects(moduleIdea
                .getModuleIdeaSubjects().stream()
                .map(ExistingSubject::toResponse)
                .collect(Collectors.toList()));
        return result;
    }
}
