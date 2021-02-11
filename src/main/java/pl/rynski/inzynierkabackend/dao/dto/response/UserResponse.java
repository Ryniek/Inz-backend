package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.User;

@Data
public class UserResponse {
    private Long id;
    private String email;

    public static UserResponse toResponse(User user) {
        UserResponse result = new UserResponse();
        result.setId(user.getId());
        result.setEmail(user.getEmail());
        return result;
    }
}
