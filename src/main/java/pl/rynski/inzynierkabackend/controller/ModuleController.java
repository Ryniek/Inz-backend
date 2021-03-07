package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.request.ModuleDto;
import pl.rynski.inzynierkabackend.service.ModuleService;

@RestController
@RequestMapping("/module")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    @Operation(summary = "Get all modules")
    @GetMapping
    public ResponseEntity<?> getModules() {
        return ResponseEntity.status(HttpStatus.OK).body(moduleService.getModules());
    }

    @Operation(summary = "Add module")
    @PostMapping
    public ResponseEntity<?> addModule(@RequestBody ModuleDto moduleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.addModule(moduleDto));
    }

    @Operation(summary = "Add subject to module")
    @PutMapping("/{moduleId}/subject/{subjectId}/add")
    public ResponseEntity<?> addSubjectToModule(@PathVariable Long moduleId, @PathVariable Long subjectId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.addSubjectToModule(moduleId, subjectId));
    }

    @Operation(summary = "Remove subject from module")
    @PutMapping("/{moduleId}/subject/{subjectId}/remove")
    public ResponseEntity<?> removeSubjectFromModule(@PathVariable Long moduleId, @PathVariable Long subjectId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.removeSubjectFromModule(moduleId, subjectId));
    }
}
