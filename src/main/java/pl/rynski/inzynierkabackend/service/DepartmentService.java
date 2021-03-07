package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.DepartmentDto;
import pl.rynski.inzynierkabackend.dao.dto.response.DepartmentResponse;
import pl.rynski.inzynierkabackend.dao.model.Department;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentResponse> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentResponse::toResponse).collect(Collectors.toList());
    }

    public DepartmentResponse addDepartment(DepartmentDto dto) {
        Department department = DepartmentDto.fromDto(dto);
        return DepartmentResponse.toResponse(departmentRepository.save(department));
    }

    public void deleteDepartment(Long id) {
        departmentRepository.delete(departmentRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Department", "id", id);
        }));
    }
}
