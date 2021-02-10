package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;

@Data
public class ContactHoursDto {
    private Integer lecture;
    private Integer exercise;
    private Integer laboratory;
    private Integer seminar;
    private Integer project;
}
