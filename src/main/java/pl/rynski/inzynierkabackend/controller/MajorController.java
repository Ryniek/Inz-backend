package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.MajorDto;
import pl.rynski.inzynierkabackend.service.MajorService;

@RestController
@RequestMapping("/major")
@RequiredArgsConstructor
public class MajorController {

    private final MajorService majorService;

    @Operation(summary = "Get all majors by department id")
    @GetMapping("/{departmentId}")
    public ResponseEntity<?> getMajorsByDepartment(@PathVariable Long departmentId, @RequestParam(required = false) Boolean hidden) {
        return ResponseEntity.ok().body(majorService.getMajorsByDepartment(departmentId, hidden));
    }

    @Operation(summary = "Add major")
    @PostMapping
    public ResponseEntity<?> addMajor(@RequestBody MajorDto majorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(majorService.addMajor(majorDto));
    }

    @Operation(summary = "Toggle hidden property of Major")
    @PutMapping("/hide/{majorId}")
    public ResponseEntity<?> toggleMajorVisibility(@PathVariable Long majorId) {
        return ResponseEntity.status(HttpStatus.OK).body(majorService.toggleMajorVisibility(majorId));
    }

    @Operation(summary = "Delete major")
    @DeleteMapping("/{majorId}")
    public ResponseEntity<?> deleteMajor(@PathVariable Long majorId) {
        majorService.deleteMajor(majorId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
