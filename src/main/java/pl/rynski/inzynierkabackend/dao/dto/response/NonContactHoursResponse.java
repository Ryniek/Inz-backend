package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.NonContactHours;

@Data
public class NonContactHoursResponse {
    private Long id;
    private Integer consultation;
    private Integer exam;
    private Integer pwt;
    private Integer pwp;

    public static NonContactHoursResponse toResponse(NonContactHours nonContactHours) {
        NonContactHoursResponse result = new NonContactHoursResponse();
        result.setId(nonContactHours.getId());
        result.setConsultation(nonContactHours.getConsultation());
        result.setExam(nonContactHours.getExam());
        result.setPwt(nonContactHours.getPwt());
        result.setPwp(nonContactHours.getPwp());
        return result;
    }
}
