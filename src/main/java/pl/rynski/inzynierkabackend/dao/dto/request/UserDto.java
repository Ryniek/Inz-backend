package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String email;
    private String password;
    //TODO repeat password validation

}
