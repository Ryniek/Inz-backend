package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModuleSubject;
import pl.rynski.inzynierkabackend.dao.model.SubjectIdea;
import pl.rynski.inzynierkabackend.utils.DateUtils;

@Data
public class DeleteSubjectIdeaDto {
    private Long majorModuleSubjectId;
    private String ideaExplanation;

    public static SubjectIdea fromDto(DeleteSubjectIdeaDto dto, MajorModuleSubject majorModuleSubject) {
        SubjectIdea result = new SubjectIdea();
        result.setExisting(true);
        result.setToRemove(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        majorModuleSubject.addSubjectIdea(result);
        return result;
    }
}
