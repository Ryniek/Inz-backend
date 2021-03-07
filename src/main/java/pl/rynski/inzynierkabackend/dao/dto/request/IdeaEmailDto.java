package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;

@Data
public class IdeaEmailDto {
    private Boolean approved;
    private String content;
}
