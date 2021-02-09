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

    private final EffectService eduOutcomesService;

    @GetMapping
    public ResponseEntity<?> getEduOutcomes() {
        return ResponseEntity.status(HttpStatus.OK).body(eduOutcomesService.getEduOutcomes());
    }

    @PostMapping
    public ResponseEntity<?> addEduOutcomes(@RequestBody EffectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eduOutcomesService.addEduOutcomes(dto));
    }

    @DeleteMapping("/{outcomeId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long outcomeId) {
        eduOutcomesService.deleteDepartment(outcomeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
