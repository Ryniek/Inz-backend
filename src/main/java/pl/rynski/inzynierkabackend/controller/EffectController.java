package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.request.EffectDto;
import pl.rynski.inzynierkabackend.service.EffectService;

@RestController
@RequestMapping("/effect")
@RequiredArgsConstructor
public class EffectController {

    private final EffectService effectService;

    @Operation(summary = "Get all major effects")
    @GetMapping
    public ResponseEntity<?> getMajorEffects() {
        return ResponseEntity.status(HttpStatus.OK).body(effectService.getMajorEffects());
    }

    @Operation(summary = "Get all major effects by specific major")
    @GetMapping("/major/{majorId}")
    public ResponseEntity<?> getEffectsByMajor(@PathVariable Long majorId) {
        return ResponseEntity.status(HttpStatus.OK).body(effectService.getEffectsByMajor(majorId));
    }

    @Operation(summary = "Get major effect by id")
    @GetMapping("/{effectId}")
    public ResponseEntity<?> getEffectById(@PathVariable Long effectId) {
        return ResponseEntity.status(HttpStatus.OK).body(effectService.getMajorEffectById(effectId));
    }

    @Operation(summary = "Add major effect")
    @PostMapping("/major/{majorId}")
    public ResponseEntity<?> addMajorEffect(@PathVariable Long majorId, @RequestBody EffectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(effectService.addMajorEffect(dto, majorId));
    }
}
