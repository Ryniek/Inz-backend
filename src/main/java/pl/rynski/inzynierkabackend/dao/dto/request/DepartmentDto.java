package pl.rynski.inzynierkabackend.dao.dto.request;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Department;

@Data
public class DepartmentDto {
    private String name;

    public static Department fromDto(DepartmentDto dto) {
        Department result = new Department();
        result.setName(dto.getName());
        return result;
    }
}
