package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.DepartmentDto;
import pl.rynski.inzynierkabackend.service.DepartmentService;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(summary = "Get all departments")
    @GetMapping
    public ResponseEntity<?> getDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartments());
    }

    @Operation(summary = "Add department")
    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(dto));
    }

    @Operation(summary = "Delete department")
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
