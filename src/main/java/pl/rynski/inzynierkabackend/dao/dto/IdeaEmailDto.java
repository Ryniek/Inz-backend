package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;

@Data
public class IdeaEmailDto {
    private Boolean approved;
    private String content;
}
