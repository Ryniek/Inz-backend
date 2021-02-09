package pl.rynski.inzynierkabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.ModuleDto;
import pl.rynski.inzynierkabackend.dao.dto.SubjectDto;
import pl.rynski.inzynierkabackend.service.ModuleService;

@RestController
@RequestMapping("/module")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping
    public ResponseEntity<?> getModules() {
        return ResponseEntity.status(HttpStatus.OK).body(moduleService.getModules());
    }

    @PostMapping
    public ResponseEntity<?> addModule(ModuleDto moduleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.addModule(moduleDto));
    }

    @PutMapping("/{moduleId}/subject")
    public ResponseEntity<?> addSubjectToModule(@PathVariable Long moduleId, @RequestBody SubjectDto subjectDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.addSubjectToModule(moduleId, subjectDto));
    }

    @PutMapping("/{moduleId}/subject/{subjectId}")
    public ResponseEntity<?> removeSubjectFromModule(@PathVariable Long moduleId, @PathVariable Long subjectId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.removeSubjectFromModule(moduleId, subjectId));
    }
}
