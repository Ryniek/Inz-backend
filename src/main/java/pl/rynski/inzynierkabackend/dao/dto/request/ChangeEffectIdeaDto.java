package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.HashSet;
import java.util.Set;

@Data
public class ChangeEffectIdeaDto {
    private String content;
    private String ideaExplanation;
    //Jesli kierunkowy to dla jakich przedmiotow z jaka sila
    private Set<MajorEffectSubjectDto> majorEffectSubjects = new HashSet<>();
    //Jesli zmieniamy przedmiotowy to wybieramy dla jakich przedmiotow chcemy zmienic
    private Set<Long> existingSubjects = new HashSet<>();

    public static EffectIdea fromDto(ChangeEffectIdeaDto dto, MajorEffect majorEffect, SubjectEffect subjectEffect, Set<EffectIdeaSubject> effectSubjects, Set<Subject> subjects, Boolean forSubject) {
        EffectIdea result = new EffectIdea();
        result.setExisting(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setContent(dto.getContent());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        result.setForSubject(forSubject);
        result.setForMajor(!forSubject);
        if(majorEffect != null) majorEffect.addEffectIdea(result);
        if(subjectEffect != null) subjectEffect.addEffectIdea(result);
        if(!effectSubjects.isEmpty()) {
            result.setEffectIdeaSubject(effectSubjects);
            effectSubjects.forEach(effectIdeaSubject -> effectIdeaSubject.setEffectIdea(result));
        }
        if(!subjects.isEmpty()) {
            result.setSubjects(subjects);
        }
        return result;
    }
}
