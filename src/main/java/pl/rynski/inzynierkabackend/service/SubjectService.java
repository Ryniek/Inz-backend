package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.response.SubjectResponse;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.ModuleRepository;
import pl.rynski.inzynierkabackend.repository.SubjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModuleRepository moduleRepository;

    public List<SubjectResponse> getSubjectsByModule(Long moduleId) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Module", "id", moduleId));
        return subjectRepository.findAll().stream()
                .filter(subject -> subject.getModules().contains(module))
                .map(SubjectResponse::toResponse)
                .collect(Collectors.toList());
    }

    public List<SubjectResponse> getSubjects() {
        return subjectRepository.findAll().stream()
                .map(SubjectResponse::toResponse)
                .collect(Collectors.toList());
    }
}
