package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.MajorModuleDto;
import pl.rynski.inzynierkabackend.service.MajorModuleService;

@RestController
@RequestMapping("/major/module")
@RequiredArgsConstructor
public class MajorModuleController {

    private final MajorModuleService majorModuleService;

    @Operation(summary = "Get all modules assigned to the specific major")
    @GetMapping("/{majorId}")
    public ResponseEntity<?> getModulesByMajor(@PathVariable Long majorId) {
        return ResponseEntity.status(HttpStatus.OK).body(majorModuleService.getModulesByMajor(majorId));
    }

    @Operation(summary = "Assign module with tutor to the specific major")
    @PostMapping
    public ResponseEntity<?> assingModuleToMajor(@RequestBody MajorModuleDto majorModuleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(majorModuleService.assingModuleToMajor(majorModuleDto));
    }
}
