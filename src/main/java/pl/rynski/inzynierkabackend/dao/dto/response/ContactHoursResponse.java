package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.ContactHours;

@Data
public class ContactHoursResponse {
    private Long id;
    private Integer lecture;
    private Integer exercise;
    private Integer laboratory;
    private Integer seminar;
    private Integer project;

    public static ContactHoursResponse toResponse(ContactHours contactHours) {
        ContactHoursResponse result = new ContactHoursResponse();
        result.setId(contactHours.getId());
        result.setLecture(contactHours.getLecture());
        result.setExercise(contactHours.getExercise());
        result.setLaboratory(contactHours.getLaboratory());
        result.setSeminar(contactHours.getSeminar());
        result.setProject(contactHours.getProject());
        return result;
    }
}
