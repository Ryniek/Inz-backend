package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.EffectIdea;
import pl.rynski.inzynierkabackend.dao.model.EffectIdeaModuleSubject;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EffectIdeaResponse {
    private Long id;
    private Boolean existing;
    private Boolean approved;
    private Boolean toRemove;
    private LocalDateTime sendingTime;
    private String content;
    private String ideaExplanation;
    private EffectType type;
    private MajorShortResponse major;
    private UserResponse user;
    private EffectResponse majorEffect;
    private List<MajorEffectSubjectResponse> majorEffectSubjects = new ArrayList<>();

    @Data
    private static class MajorEffectSubjectResponse {
        private Long subjectId;
        private String subjectName;
        private String subjectCode;
        private Integer connectionStrength;

        private static MajorEffectSubjectResponse toResponse(EffectIdeaModuleSubject effectIdeaModuleSubject) {
            MajorEffectSubjectResponse result = new MajorEffectSubjectResponse();
            result.setSubjectId(effectIdeaModuleSubject.getMajorModuleSubject().getSubject().getId());
            result.setSubjectName(effectIdeaModuleSubject.getMajorModuleSubject().getSubject().getName());
            result.setSubjectCode(effectIdeaModuleSubject.getMajorModuleSubject().getSubject().getSubjectCode());
            result.setConnectionStrength(effectIdeaModuleSubject.getConnectionStrength());
            return result;
        }
    }

    public static EffectIdeaResponse toResponse(EffectIdea effectIdea) {
        EffectIdeaResponse result = new EffectIdeaResponse();
        result.setId(effectIdea.getId());
        result.setExisting(effectIdea.getExisting());
        result.setApproved(effectIdea.getApproved());
        result.setToRemove(effectIdea.getToRemove());
        result.setSendingTime(effectIdea.getSendingTime());
        result.setContent(effectIdea.getContent());
        result.setIdeaExplanation(effectIdea.getIdeaExplanation());
        result.setType(effectIdea.getType());
        if(effectIdea.getMajor() != null) result.setMajor(MajorShortResponse.toResponse(effectIdea.getMajor()));
        result.setUser(UserResponse.toResponse(effectIdea.getUser()));
        if(effectIdea.getMajorEffect() != null) result.setMajorEffect(EffectResponse.toResponse(effectIdea.getMajorEffect()));
        //TODO sprawdzic czy tutaj nie wywali nulla przy dodawaniu nowego efektu(pomyslu)
        result.setMajorEffectSubjects(effectIdea.getEffectIdeaModuleSubject().stream()
                .map(MajorEffectSubjectResponse::toResponse)
                .collect(Collectors.toList()));
        return result;
    }
}
