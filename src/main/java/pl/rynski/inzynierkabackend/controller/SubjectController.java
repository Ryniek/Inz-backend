package pl.rynski.inzynierkabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rynski.inzynierkabackend.service.SubjectService;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    //TODO getSubjects by moduleId - tak zrobic + dodawanie/usuwanie/edycje
    @GetMapping("/{moduleId}")
    public ResponseEntity<?> getSubjectsByModule(@PathVariable Long moduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectsByModule(moduleId));
    }
}
