package pl.rynski.inzynierkabackend.dao.dto.response;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Department;

@Data
public class DepartmentResponse {
    private Long id;
    private String name;

    public static DepartmentResponse toResponse(Department department) {
        DepartmentResponse result = new DepartmentResponse();
        result.setId(department.getId());
        result.setName(department.getName());
        return result;
    }
}
