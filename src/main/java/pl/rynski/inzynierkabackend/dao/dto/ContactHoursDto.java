package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.ContactHours;

@Data
public class ContactHoursDto {
    private Integer lecture;
    private Integer exercise;
    private Integer laboratory;
    private Integer seminar;
    private Integer project;

    public static ContactHours fromDto(ContactHoursDto dto) {
        ContactHours result = new ContactHours();
        result.setLecture(dto.getLecture());
        result.setExercise(dto.getExercise());
        result.setLaboratory(dto.getLaboratory());
        result.setSeminar(dto.getSeminar());
        result.setProject(dto.getProject());
        return result;
    }
}
