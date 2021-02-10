package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class NonContactHoursDto {
    private Integer consultation;
    private Integer exam;
    private Integer pwt;
    private Integer pwp;
}
