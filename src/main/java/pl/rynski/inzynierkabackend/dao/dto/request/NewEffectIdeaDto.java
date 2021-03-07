package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.EffectIdea;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffectIdea;
import pl.rynski.inzynierkabackend.dao.model.enums.EffectType;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class NewEffectIdeaDto {
    private String content;
    private String ideaExplanation;
    private EffectType type;
    private Boolean forSubject;
    private Boolean forMajor;
    //TODO walidacja ze jak forSubject true to majorIds empty i na odwrot
    private Set<SubjectEffectDto> subjects = new HashSet<>();
    private Set<Long> majorIds = new HashSet<>();

    public static EffectIdea fromDto(NewEffectIdeaDto dto, Set<SubjectEffectIdea> subjects, List<Major> majors) {
        EffectIdea result = new EffectIdea();
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setContent(dto.getContent());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setType(dto.getType());
        result.setForMajor(dto.getForSubject());
        result.setForMajor(dto.getForMajor());
        result.setSubjectEffectIdeas(subjects);
        subjects.forEach(subject -> subject.setEffectIdea(result));
        majors.forEach(result::addMajor);
        return result;
    }
}
