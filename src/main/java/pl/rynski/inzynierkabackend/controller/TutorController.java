package pl.rynski.inzynierkabackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rynski.inzynierkabackend.dao.dto.TutorDto;
import pl.rynski.inzynierkabackend.service.TutorService;

@RestController
@RequestMapping("/tutor")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @Operation(summary = "Get all tutors")
    @GetMapping
    public ResponseEntity<?> getTutors() {
        return ResponseEntity.status(HttpStatus.OK).body(tutorService.getTutors());
    }

    @Operation(summary = "Add tutor")
    @PostMapping
    public ResponseEntity<?> addTutor(@RequestBody TutorDto tutorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorService.addTutor(tutorDto));
    }
}
