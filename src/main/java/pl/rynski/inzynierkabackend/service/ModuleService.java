package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.ModuleDto;
import pl.rynski.inzynierkabackend.dao.dto.response.ModuleResponse;
import pl.rynski.inzynierkabackend.dao.dto.SubjectDto;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.dao.model.Subject;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.ModuleRepository;
import pl.rynski.inzynierkabackend.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final SubjectRepository subjectRepository;

    public List<ModuleResponse> getModules() {
        return moduleRepository.findAll().stream()
                .map(ModuleResponse::toResponse)
                .collect(Collectors.toList());
    }

    public ModuleResponse addModule(ModuleDto moduleDto) {
        Module module = ModuleDto.fromDto(moduleDto);
        return ModuleResponse.toResponse(moduleRepository.save(module));
    }

    public ModuleResponse addSubjectToModule(Long moduleId, SubjectDto subjectDto) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Module", "id", moduleId));
        Optional<Subject> existingSubject = subjectRepository.findBySubjectCode(subjectDto.getSubjectCode());
        if(existingSubject.isPresent()) {
            module.addSubject(existingSubject.get());
        } else {
            module.addSubject(SubjectDto.fromDto(subjectDto));
        }
        return ModuleResponse.toResponse(moduleRepository.save(module));
    }

    public ModuleResponse removeSubjectFromModule(Long moduleId, Long subjectId) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Module", "id", moduleId));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", "id", subjectId));
        module.removeSubject(subject);
        return ModuleResponse.toResponse(moduleRepository.save(module));
    }
}
