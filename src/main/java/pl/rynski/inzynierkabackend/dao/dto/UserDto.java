package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;
    //TODO repeat password validation

}
