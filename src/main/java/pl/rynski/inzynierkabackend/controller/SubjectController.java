package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Operation(summary = "Get all subjects")
    @GetMapping
    public ResponseEntity<?> getSubjects() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjects());
    }
}
