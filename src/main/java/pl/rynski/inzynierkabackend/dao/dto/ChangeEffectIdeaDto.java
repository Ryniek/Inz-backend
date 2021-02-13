package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ChangeEffectIdeaDto {
    private String content;
    private String ideaExplanation;
    //TODO albo jedno albo drugie
    private Set<Long> majorIds = new HashSet<>();
    private Set<SubjectEffectDto> existingSubjects = new HashSet<>();

    public static EffectIdea fromDto(ChangeEffectIdeaDto dto, List<Major> majors, Set<SubjectEffectIdea> subjects) {
        EffectIdea result = new EffectIdea();
        result.setExisting(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setContent(dto.getContent());
        majors.forEach(result::addMajor);
        result.setSubjectEffectIdeas(subjects);
        subjects.forEach(subject -> subject.setEffectIdea(result));
        return result;
    }
}
