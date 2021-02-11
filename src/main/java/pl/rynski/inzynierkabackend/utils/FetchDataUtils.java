package pl.rynski.inzynierkabackend.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.*;

@Service
@RequiredArgsConstructor
public class FetchDataUtils {
    private final ModuleSubjectRepository moduleSubjectRepository;
    private final MajorModuleRepository majorModuleRepository;
    private final TutorRepository tutorRepository;
    private final EffectRepository effectRepository;
    private final SubjectIdeaRepository subjectIdeaRepository;
    private final SubjectRepository subjectRepository;
    private final ModuleRepository moduleRepository;
    private final MajorRepository majorRepository;
    private final DepartmentRepository departmentRepository;

    public Department departmentById(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId));
    }

    public Major majorById(Long majorId) {
        return majorRepository.findById(majorId)
                .orElseThrow(() -> new ResourceNotFoundException("Major", "id", majorId));
    }

    public Module moduleById(Long moduleId) {
        return moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Module", "id", moduleId));
    }

    public Subject subjectById(Long subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", "id", subjectId));
    }

    public Tutor tutorById(Long tutorId) {
        return tutorRepository.findById(tutorId)
                .orElseThrow(() -> new ResourceNotFoundException("Tutor", "id", tutorId));
    }

    public Effect effectById(Long effectId) {
        return effectRepository.findById(effectId)
                .orElseThrow(() -> new ResourceNotFoundException("Effect", "id", effectId));
    }

    public SubjectIdea subjectIdeaById(Long subjectIdeaId) {
        return subjectIdeaRepository.findById(subjectIdeaId)
                .orElseThrow(() -> new ResourceNotFoundException("SubjectIdea", "id", subjectIdeaId));
    }

    public MajorModule majorModuleById(Long majorModuleId) {
        return majorModuleRepository.findById(majorModuleId)
                .orElseThrow(() -> new ResourceNotFoundException("MajorModule", "id", majorModuleId));
    }

    public MajorModuleSubject moduleSubjectById(Long moduleSubjectId) {
        return moduleSubjectRepository.findById(moduleSubjectId)
                .orElseThrow(() -> new ResourceNotFoundException("MajorModuleSubject", "id", moduleSubjectId));
    }
}
