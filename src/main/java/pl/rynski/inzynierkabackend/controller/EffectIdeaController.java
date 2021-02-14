package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.*;
import pl.rynski.inzynierkabackend.service.EffectIdeaService;

@RestController
@RequestMapping("/effect/idea")
@RequiredArgsConstructor
public class EffectIdeaController {

    private final EffectIdeaService effectIdeaService;

    @Operation(summary = "Get all effects limited by pagination divided on approved/not approved/unanswered")
    @GetMapping
    public ResponseEntity<?> getAllEffectIdeas(@RequestParam(required = false) Boolean approved, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.status(HttpStatus.OK).body(effectIdeaService.getAllEffectIdeas(approved, page, size));
    }

    @Operation(summary = "Send email with response")
    @PostMapping("/mail/{effectIdeaId}")
    public ResponseEntity<?> respondOnEffectIdea(@PathVariable Long effectIdeaId, @RequestBody IdeaEmailDto ideaEmailDto) {
        return ResponseEntity.status(HttpStatus.OK).body(effectIdeaService.respondOnEffectIdea(effectIdeaId, ideaEmailDto));
    }

    @Operation(summary = "Add idea of new effect")
    @PostMapping("/new")
    public ResponseEntity<?> addNewEffectIdea(@RequestBody NewEffectIdeaDto newEffectIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(effectIdeaService.addNewEffectIdea(newEffectIdeaDto));
    }

    @Operation(summary = "Add idea of changing existing effect")
    @PostMapping("/change/{effectId}")
    public ResponseEntity<?> addChangeEffectIdea(@PathVariable Long effectId, @RequestBody ChangeEffectIdeaDto changeEffectIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(effectIdeaService.addChangeEffectIdea(effectId, changeEffectIdeaDto));
    }

    @Operation(summary = "Add idea of deleting existing effect")
    @PostMapping("/delete")
    public ResponseEntity<?> addDeleteEffectIdea(@RequestBody DeleteIdeaDto deleteIdeaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(effectIdeaService.addDeleteEffectIdea(deleteIdeaDto));
    }

    @Operation(summary = "Delete effect idea")
    @DeleteMapping("/{effectIdeaId}")
    public ResponseEntity<?> deleteEffectIdea(@PathVariable Long effectIdeaId) {
        effectIdeaService.deleteEffectIdea(effectIdeaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
