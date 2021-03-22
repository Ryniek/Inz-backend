package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.EffectIdea;
import pl.rynski.inzynierkabackend.dao.model.EffectIdeaSubject;
import pl.rynski.inzynierkabackend.dao.model.MajorEffectSubject;
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
    private SubjectShortResponse subject;
    private Boolean forSubject;
    private Boolean forMajor;
    private UserResponse user;
    private EffectResponse majorEffect;
    private EffectResponse subjectEffect;
    private List<MajorEffectSubjectResponse> majorEffectSubjects = new ArrayList<>();
    private List<SubjectShortResponse> subjects = new ArrayList<>();

    @Data
    private static class MajorEffectSubjectResponse {
        private Long id;
        private String name;
        private String subjectCode;
        private Integer connectionStrength;

        private static MajorEffectSubjectResponse toResponse(EffectIdeaSubject effectIdeaSubject) {
            MajorEffectSubjectResponse result = new MajorEffectSubjectResponse();
            result.setId(effectIdeaSubject.getSubject().getId());
            result.setName(effectIdeaSubject.getSubject().getName());
            result.setSubjectCode(effectIdeaSubject.getSubject().getSubjectCode());
            result.setConnectionStrength(effectIdeaSubject.getConnectionStrength());
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
        if(effectIdea.getSubject() != null) result.setSubject(SubjectShortResponse.toResponse(effectIdea.getSubject()));
        result.setForSubject(effectIdea.getForSubject());
        result.setForMajor(effectIdea.getForMajor());
        result.setUser(UserResponse.toResponse(effectIdea.getUser()));
        if(effectIdea.getMajorEffect() != null) result.setMajorEffect(EffectResponse.toResponse(effectIdea.getMajorEffect()));
        if(effectIdea.getSubjectEffect() != null) result.setSubjectEffect(EffectResponse.toResponse(effectIdea.getSubjectEffect()));
        result.setMajorEffectSubjects(effectIdea.getEffectIdeaSubject().stream()
                .map(MajorEffectSubjectResponse::toResponse)
                .collect(Collectors.toList()));
        result.setSubjects(effectIdea.getSubjects().stream()
                .map(SubjectShortResponse::toResponse)
                .collect(Collectors.toList()));
        return result;
    }
}
