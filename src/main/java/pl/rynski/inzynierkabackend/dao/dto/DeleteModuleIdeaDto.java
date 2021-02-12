package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;
import pl.rynski.inzynierkabackend.dao.model.ModuleIdea;
import pl.rynski.inzynierkabackend.utils.DateUtils;

@Data
public class DeleteModuleIdeaDto {
    private Long majorModuleId;
    private String ideaExplanation;

    public static ModuleIdea fromDto(DeleteModuleIdeaDto dto, MajorModule majorModule) {
        ModuleIdea result = new ModuleIdea();
        result.setExisting(true);
        result.setToRemove(true);
        result.setSendingTime(DateUtils.getCurrentDateTime());
        result.setIdeaExplanation(dto.getIdeaExplanation());
        majorModule.addModuleIdea(result);
        return result;
    }
}
