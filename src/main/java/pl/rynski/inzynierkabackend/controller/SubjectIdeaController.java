package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.ChangeSubjectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.DeleteIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.request.IdeaEmailDto;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.NewSubjectIdeaDto;
import pl.rynski.inzynierkabackend.service.SubjectIdeaService;

@RestController
@RequestMapping("/subject/idea")
@RequiredArgsConstructor
public class SubjectIdeaController {

    private final SubjectIdeaService subjectIdeaService;

    @Operation(summary = "Get all subjects limited by pagination divided on approved/not approved/unanswered")
    @GetMapping
    public ResponseEntity<?> getAllSubjectIdeas(@RequestParam(required = false) Boolean approved, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectIdeaService.getAllSubjectIdeas(approved, page, size));
    }

    @Operation(summary = "Send email with response")
    @PostMapping("/mail/{subjectIdeaId}")
    public ResponseEntity<?> respondOnSubjectIdea(@PathVariable Long subjectIdeaId, @RequestBody IdeaEmailDto ideaEmailDto) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectIdeaService.respondOnSubjectIdea(subjectIdeaId, ideaEmailDto));
    }

    @Operation(summary = "Add idea of new subject")
    @PostMapping("/new")
    public ResponseEntity<?> addNewSubjectIdea(@RequestBody NewSubjectIdeaDto newSubjectIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectIdeaService.addNewSubjectIdea(newSubjectIdeaDto));
    }

    @Operation(summary = "Add idea of changing existing subject")
    @PostMapping("/change/{moduleSubjectId}")
    public ResponseEntity<?> addChangeSubjectIdea(@PathVariable Long moduleSubjectDetailsId, @RequestBody ChangeSubjectIdeaDto changeSubjectIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectIdeaService.addChangeSubjectIdea(moduleSubjectDetailsId, changeSubjectIdeaDto));
    }

    @Operation(summary = "Add idea of deleting existing subject")
    @PostMapping("/delete")
    public ResponseEntity<?> addDeleteSubjectIdea(@RequestBody DeleteIdeaDto deleteIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectIdeaService.addDeleteSubjectIdea(deleteIdeaDto));
    }

    @Operation(summary = "Delete subject idea")
    @DeleteMapping("/{subjectIdeaId}")
    public ResponseEntity<?> deleteSubjectIdea(@PathVariable Long subjectIdeaId) {
        subjectIdeaService.deleteSubjectIdea(subjectIdeaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
