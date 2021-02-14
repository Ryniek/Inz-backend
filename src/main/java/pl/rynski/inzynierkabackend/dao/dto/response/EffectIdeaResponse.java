package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.EffectIdea;
import pl.rynski.inzynierkabackend.dao.model.MajorSubjectEffect;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffectIdea;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private Boolean forSubject;
    private Boolean forMajor;
    private UserResponse user;
    private EffectResponse editedEffect;
    private List<EffectResponse.ExistingSubject> subjects = new ArrayList<>();
    private List<MajorShortResponse> majors = new ArrayList<>();

    @Data
    private static class EffectResponse {
        private Long id;
        private String code;
        private String content;
        private EffectType type;
        private Boolean forSubject;
        private Boolean forMajor;
        private Set<ExistingSubject> majorSubjects = new HashSet<>();
        private Set<MajorShortResponse> majors = new HashSet<>();

        @Data
        private static class ExistingSubject {
            private SubjectResponse subject;
            private Integer connectionStrength;

            public static ExistingSubject toResponse(SubjectEffectIdea subjectEffectIdea) {
                ExistingSubject result = new ExistingSubject();
                result.setSubject(SubjectResponse.toResponse(subjectEffectIdea.getMajorModuleSubject().getSubject()));
                result.setConnectionStrength(subjectEffectIdea.getConnectionStrength());
                return result;
            }

            public static ExistingSubject toResponse(MajorSubjectEffect majorSubjectEffect) {
                ExistingSubject result = new ExistingSubject();
                result.setSubject(SubjectResponse.toResponse(majorSubjectEffect.getMajorModuleSubject().getSubject()));
                result.setConnectionStrength(majorSubjectEffect.getConnectionStrength());
                return result;
            }
        }

        private static EffectResponse toResponse(Effect effect) {
            EffectResponse result = new EffectResponse();
            result.setId(effect.getId());
            result.setCode(effect.getCode());
            result.setContent(effect.getContent());
            result.setType(effect.getType());
            result.setForSubject(effect.getForSubject());
            result.setForMajor(effect.getForMajor());
            result.setMajorSubjects(effect
                    .getMajorSubjectEffects().stream()
                    .map(ExistingSubject::toResponse)
                    .collect(Collectors.toSet()));
            result.setMajors(effect
                    .getMajors().stream()
                    .map(MajorShortResponse::toResponse)
                    .collect(Collectors.toSet()));
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
        result.setForSubject(effectIdea.getForSubject());
        result.setForMajor(effectIdea.getForMajor());
        if(effectIdea.getUser() != null) result.setUser(UserResponse.toResponse(effectIdea.getUser()));
        if(effectIdea.getEffect() != null) result.setEditedEffect(EffectResponse.toResponse(effectIdea.getEffect()));
        result.setSubjects(effectIdea
                .getSubjectEffectIdeas().stream()
                .map(EffectResponse.ExistingSubject::toResponse)
                .collect(Collectors.toList()));
        result.setMajors(effectIdea
                .getMajors().stream()
                .map(MajorShortResponse::toResponse)
                .collect(Collectors.toList()));
        return result;
    }
}
