package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.dao.model.MajorEffectSubject;
import pl.rynski.inzynierkabackend.dao.model.Subject;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SubjectResponse {
    private Long id;
    private String name;
    private String subjectCode;
    private List<EffectResponse> subjectEffects = new ArrayList<>();
    private List<MajorEffectResponse> majorEffects = new ArrayList<>();

    @Data
    private static class MajorEffectResponse {
        private Long id;
        private String code;
        private String content;
        private EffectType type;
        private Integer connectionStrength;

        private static MajorEffectResponse toResponse(MajorEffectSubject majorEffect) {
            MajorEffectResponse result = new MajorEffectResponse();
            result.setId(majorEffect.getMajorEffect().getId());
            result.setCode(majorEffect.getMajorEffect().getCode());
            result.setContent(majorEffect.getMajorEffect().getContent());
            result.setType(majorEffect.getMajorEffect().getType());
            result.setConnectionStrength(majorEffect.getConnectionStrength());
            return result;
        }
    }

    public static SubjectResponse toResponse(Subject subject) {
        SubjectResponse result = new SubjectResponse();
        result.setId(subject.getId());
        result.setName(subject.getName());
        result.setSubjectCode(subject.getSubjectCode());
        result.setSubjectEffects(subject
                .getSubjectEffects().stream()
                .map(EffectResponse::toResponse)
                .collect(Collectors.toList()));
        result.setMajorEffects(subject
                .getMajorEffects().stream()
                .map(MajorEffectResponse::toResponse)
                .collect(Collectors.toList()));
        return result;
    }
}
