package pl.rynski.inzynierkabackend.controller;

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

    @GetMapping
    public ResponseEntity<?> getDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartments());
    }

    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(dto));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
