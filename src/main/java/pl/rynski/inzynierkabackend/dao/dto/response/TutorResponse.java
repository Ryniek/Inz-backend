package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Tutor;

@Data
public class TutorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String degree;

    public static TutorResponse toResponse(Tutor tutor) {
        TutorResponse result = new TutorResponse();
        result.setId(tutor.getId());
        result.setFirstName(tutor.getFirstName());
        result.setLastName(tutor.getLastName());
        result.setDegree(tutor.getDegree());
        return result;
    }
}
