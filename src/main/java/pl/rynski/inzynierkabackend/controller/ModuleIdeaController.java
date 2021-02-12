package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.*;
import pl.rynski.inzynierkabackend.service.ModuleIdeaService;

@RestController
@RequestMapping("/module/idea")
@RequiredArgsConstructor
public class ModuleIdeaController {

    private final ModuleIdeaService moduleIdeaService;

    @Operation(summary = "Get all modules limited by pagination divided on approved/not approved/unanswered")
    @GetMapping
    public ResponseEntity<?> getAllModuleIdeas(@RequestParam(required = false) Boolean approved, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.status(HttpStatus.OK).body(moduleIdeaService.getAllModuleIdeas(approved, page, size));
    }

    @Operation(summary = "Add idea of new module")
    @PostMapping("/new")
    public ResponseEntity<?> addNewModuleIdea(@RequestBody NewModuleIdeaDto newModuleIdeaDto) {
        moduleIdeaService.addNewModuleIdea(newModuleIdeaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Add idea of changing existing module")
    @PostMapping("/change/{majorModuleId}")
    public ResponseEntity<?> addChangeModuleIdea(@PathVariable Long majorModuleId, @RequestBody ChangeModuleIdeaDto changeModuleIdeaDto) {
        moduleIdeaService.addChangeModuleIdea(majorModuleId, changeModuleIdeaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Add idea of deleting existing module")
    @PostMapping("/delete")
    public ResponseEntity<?> addDeleteModuleIdea(@RequestBody DeleteModuleIdeaDto deleteModuleIdeaDto) {
        moduleIdeaService.addDeleteModuleIdea(deleteModuleIdeaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Delete module idea")
    @DeleteMapping("/{moduleIdeaId}")
    public ResponseEntity<?> deleteModuleIdea(@PathVariable Long moduleIdeaId) {
        moduleIdeaService.deleteModuleIdea(moduleIdeaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
