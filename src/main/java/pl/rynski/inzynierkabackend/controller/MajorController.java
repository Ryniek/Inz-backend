package pl.rynski.inzynierkabackend.controller;

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

    @GetMapping("/{departmentId}")
    public ResponseEntity<?> getMajorsByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok().body(majorService.getMajorsByDepartment(departmentId));
    }

    @PostMapping
    public ResponseEntity<?> addMajor(@RequestBody MajorDto majorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(majorService.addMajor(majorDto));
    }

    @PutMapping("/hide/{majorId}")
    public ResponseEntity<?> toggleMajorVisibility(@PathVariable Long majorId) {
        return ResponseEntity.status(HttpStatus.OK).body(majorService.toggleMajorVisibility(majorId));
    }

    @DeleteMapping("/{majorId}")
    public ResponseEntity<?> deleteMajor(@PathVariable Long majorId) {
        majorService.deleteMajor(majorId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
