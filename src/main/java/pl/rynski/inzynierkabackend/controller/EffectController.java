package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.request.MajorEffectDto;
import pl.rynski.inzynierkabackend.dao.dto.request.SubjectEffectDto;
import pl.rynski.inzynierkabackend.service.EffectService;

@RestController
@RequestMapping("/effect")
@RequiredArgsConstructor
public class EffectController {

    private final EffectService effectService;

    @Operation(summary = "Get all effects for subjects or majors")
    @GetMapping
    public ResponseEntity<?> getEffects(@RequestParam Boolean forSubject) {
        return ResponseEntity.status(HttpStatus.OK).body(effectService.getEffects(forSubject));
    }

    @Operation(summary = "Get all major effects by specific major")
    @GetMapping("/major/{majorId}")
    public ResponseEntity<?> getEffectsByMajor(@PathVariable Long majorId) {
        return ResponseEntity.status(HttpStatus.OK).body(effectService.getEffectsByMajor(majorId));
    }

    @Operation(summary = "Get effect by id for subjects or majors")
    @GetMapping("/{effectId}")
    public ResponseEntity<?> getEffectById(@PathVariable Long effectId, @RequestParam Boolean forSubject) {
        return ResponseEntity.status(HttpStatus.OK).body(effectService.getEffectById(effectId, forSubject));
    }

    @Operation(summary = "Add major effect")
    @PostMapping("/major/{majorId}")
    public ResponseEntity<?> addMajorEffect(@PathVariable Long majorId, @RequestBody MajorEffectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(effectService.addMajorEffect(dto, majorId));
    }

    @Operation(summary = "Add subject effect")
    @PostMapping("/subject")
    public ResponseEntity<?> addMajorEffect(@RequestBody SubjectEffectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(effectService.addSubjectEffect(dto));
    }
}
