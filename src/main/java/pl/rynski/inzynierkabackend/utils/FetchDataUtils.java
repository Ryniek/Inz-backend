package pl.rynski.inzynierkabackend.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchDataUtils {
    private final ModuleSubjectRepository moduleSubjectRepository;
    private final MajorModuleRepository majorModuleRepository;
    private final TutorRepository tutorRepository;
    private final SubjectIdeaRepository subjectIdeaRepository;
    private final SubjectRepository subjectRepository;
    private final ModuleRepository moduleRepository;
    private final MajorRepository majorRepository;
    private final DepartmentRepository departmentRepository;
    private final ModuleIdeaRepository moduleIdeaRepository;
    private final EffectIdeaRepository effectIdeaRepository;
    private final MajorEffectRepository majorEffectRepository;
    private final SubjectEffectRepository subjectEffectRepository;

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

    public SubjectIdea subjectIdeaById(Long subjectIdeaId) {
        return subjectIdeaRepository.findById(subjectIdeaId)
                .orElseThrow(() -> new ResourceNotFoundException("SubjectIdea", "id", subjectIdeaId));
    }

    public ModuleIdea moduleIdeaById(Long moduleIdeaId) {
        return moduleIdeaRepository.findById(moduleIdeaId)
                .orElseThrow(() -> new ResourceNotFoundException("ModuleIdea", "id", moduleIdeaId));
    }

    public SubjectEffect subjectEffectById(Long subjectEffectId) {
        return subjectEffectRepository.findById(subjectEffectId)
                .orElseThrow(() -> new ResourceNotFoundException("SubjectEffect", "id", subjectEffectId));
    }

    public MajorEffect majorEffectById(Long majorEffectId) {
        return majorEffectRepository.findById(majorEffectId)
                .orElseThrow(() -> new ResourceNotFoundException("MajorEffect", "id", majorEffectId));
    }

    public EffectIdea effectIdeaById(Long effectIdeaId) {
        return effectIdeaRepository.findById(effectIdeaId)
                .orElseThrow(() -> new ResourceNotFoundException("EffectIdea", "id", effectIdeaId));
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
