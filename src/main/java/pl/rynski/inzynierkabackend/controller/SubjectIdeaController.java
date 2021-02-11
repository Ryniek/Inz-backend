package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.ChangeSubjectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.DeleteSubjectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.NewSubjectIdeaDto;
import pl.rynski.inzynierkabackend.service.SubjectIdeaService;

@RestController
@RequestMapping("/subject/idea")
@RequiredArgsConstructor
public class SubjectIdeaController {

    private final SubjectIdeaService subjectIdeaService;

    @Operation(summary = "Add idea of new subject")
    @PostMapping("/new")
    public ResponseEntity<?> addNewSubjectIdea(@RequestBody NewSubjectIdeaDto newSubjectIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectIdeaService.addNewSubjectIdea(newSubjectIdeaDto));
    }

    @Operation(summary = "Add idea of changing existing subject")
    @PostMapping("/change/{moduleSubjectId}")
    public ResponseEntity<?> addChangeSubjectIdea(@PathVariable Long moduleSubjectId, @RequestBody ChangeSubjectIdeaDto changeSubjectIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectIdeaService.addChangeSubjectIdea(moduleSubjectId, changeSubjectIdeaDto));
    }

    @Operation(summary = "Add idea of deleting existing subject")
    @PostMapping("/delete")
    public ResponseEntity<?> addDeleteSubjectIdea(@RequestBody DeleteSubjectIdeaDto deleteSubjectIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectIdeaService.addDeleteSubjectIdea(deleteSubjectIdeaDto));
    }

    @Operation(summary = "Delete the subject idea")
    @DeleteMapping("/{subjectIdeaId}")
    public ResponseEntity<?> deleteSubjectIdea(@PathVariable Long subjectIdeaId) {
        subjectIdeaService.deleteSubjectIdea(subjectIdeaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
