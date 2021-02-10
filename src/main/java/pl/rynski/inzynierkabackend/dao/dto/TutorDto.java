package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Tutor;

@Data
public class TutorDto {
    private String firstName;
    private String lastName;
    private String degree;

    public static Tutor fromDto(TutorDto dto) {
        Tutor result = new Tutor();
        result.setFirstName(dto.getFirstName());
        result.setLastName(dto.getLastName());
        result.setDegree(dto.getDegree());
        return result;
    }
}
