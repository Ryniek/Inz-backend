package pl.rynski.inzynierkabackend.controller;

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

    @GetMapping
    public ResponseEntity<?> getEffects(@RequestParam Boolean forSubject) {
        return ResponseEntity.status(HttpStatus.OK).body(effectService.getEffects(forSubject));
    }

    @PostMapping
    public ResponseEntity<?> addEffect(@RequestBody EffectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(effectService.addEffect(dto));
    }

    @DeleteMapping("/{effectId}")
    public ResponseEntity<?> deleteEffect(@PathVariable Long effectId) {
        effectService.deleteEffect(effectId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
