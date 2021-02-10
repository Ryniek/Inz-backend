package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.NonContactHours;

@Data
public class NonContactHoursDto {
    private Integer consultation;
    private Integer exam;
    private Integer pwt;
    private Integer pwp;

    public static NonContactHours fromDto(NonContactHoursDto dto) {
        NonContactHours result = new NonContactHours();
        result.setConsultation(dto.getConsultation());
        result.setExam(dto.getExam());
        result.setPwt(dto.getPwt());
        result.setPwp(dto.getPwt());
        return result;
    }
}
