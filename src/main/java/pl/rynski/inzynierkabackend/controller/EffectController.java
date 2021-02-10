package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.EffectDto;
import pl.rynski.inzynierkabackend.service.EffectService;

@RestController
@RequestMapping("/effect")
@RequiredArgsConstructor
public class EffectController {

    private final EffectService effectService;

    @Operation(summary = "Get all effects")
    @GetMapping
    public ResponseEntity<?> getEffects(@RequestParam Boolean forSubject) {
        return ResponseEntity.status(HttpStatus.OK).body(effectService.getEffects(forSubject));
    }

    @Operation(summary = "Add effect")
    @PostMapping
    public ResponseEntity<?> addEffect(@RequestBody EffectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(effectService.addEffect(dto));
    }

    @Operation(summary = "Delete effect")
    @DeleteMapping("/{effectId}")
    public ResponseEntity<?> deleteEffect(@PathVariable Long effectId) {
        effectService.deleteEffect(effectId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
