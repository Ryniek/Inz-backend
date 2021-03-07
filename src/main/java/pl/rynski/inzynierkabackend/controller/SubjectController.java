package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.request.SubjectDto;
import pl.rynski.inzynierkabackend.service.SubjectService;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @Operation(summary = "Get all subjects by module id")
    @GetMapping("/{moduleId}")
    public ResponseEntity<?> getSubjectsByModule(@PathVariable Long moduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectsByModule(moduleId));
    }

    @Operation(summary = "Get all subjects by effect id")
    @GetMapping("/effect/{effectId}")
    public ResponseEntity<?> getSubjectsByEffect(@PathVariable Long effectId) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectsByEffect(effectId));
    }

    @Operation(summary = "Get all subjects")
    @GetMapping
    public ResponseEntity<?> getSubjects() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjects());
    }

    @Operation(summary = "Add subject")
    @PostMapping
    public ResponseEntity<?> addSubject(@RequestBody SubjectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.addSubject(dto));
    }
}
