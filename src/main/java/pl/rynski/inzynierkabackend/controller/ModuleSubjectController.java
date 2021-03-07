package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.request.ModuleSubjectDto;
import pl.rynski.inzynierkabackend.service.ModuleSubjectService;

@RestController
@RequestMapping("/module/subject")
@RequiredArgsConstructor
public class ModuleSubjectController {

    private final ModuleSubjectService moduleSubjectService;

    @Operation(summary = "Get moduleSubject by id")
    @GetMapping("/{moduleSubjectId}")
    public ResponseEntity<?> getModuleSubjectById(@PathVariable Long moduleSubjectId) {
        return ResponseEntity.status(HttpStatus.OK).body(moduleSubjectService.getModuleSubjectById(moduleSubjectId));
    }

    @Operation(summary = "Add Subject with all data(hours, ects etc.) to the module")
    @PostMapping("/{majorModuleId}")
    public ResponseEntity<?> addModuleSubjectToModule(@PathVariable Long majorModuleId, @RequestBody ModuleSubjectDto moduleSubjectDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(moduleSubjectService.addModuleSubjectToModule(majorModuleId, moduleSubjectDto));
    }

    @Operation(summary = "Delete Subject with all data(hours, ects etc.) from the module")
    @DeleteMapping("/{moduleSubjectId}")
    public ResponseEntity<?> deleteModuleSubject(@PathVariable Long moduleSubjectId) {
        moduleSubjectService.deleteModuleSubject(moduleSubjectId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
