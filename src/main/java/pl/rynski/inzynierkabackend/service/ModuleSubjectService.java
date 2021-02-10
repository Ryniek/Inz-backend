package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.ModuleSubjectDto;
import pl.rynski.inzynierkabackend.dao.dto.SubjectEffectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.ModuleSubjectResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.*;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleSubjectService {

    private final ModuleSubjectRepository moduleSubjectRepository;
    private final MajorModuleRepository majorModuleRepository;
    private final SubjectRepository subjectRepository;
    private final TutorRepository tutorRepository;
    private final EffectRepository effectRepository;

    public ModuleSubjectResponse addModuleSubjectToModule(Long majorModuleId, ModuleSubjectDto moduleSubjectDto) {
        MajorModule majorModule = majorModuleRepository.findById(majorModuleId)
                .orElseThrow(() -> new ResourceNotFoundException("MajorModule", "id", majorModuleId));
        Subject subject = subjectRepository.findById(moduleSubjectDto.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject", "id", moduleSubjectDto.getSubjectId()));
        Tutor tutor = tutorRepository.findById(moduleSubjectDto.getTutorId())
                .orElseThrow(() -> new ResourceNotFoundException("Tutor", "id", moduleSubjectDto.getTutorId()));

        //TODO sprawdzic czy przedmiot byl juz przypisany wczesniej do danego modulu
        //TODO walidacja czy efekt jest dla przedmiotu
        Set<MajorSubjectEffect> effects = new HashSet<>();
        moduleSubjectDto.getEffects().forEach(effect -> {
            MajorSubjectEffect singleEffect = new MajorSubjectEffect();
            singleEffect.setEffect(effectRepository.findById(effect.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Effect", "id", effect.getId())));
            singleEffect.setConnectionStrength(effect.getConnectionStrength());
            effects.add(singleEffect);
        });

        MajorModuleSubject result = ModuleSubjectDto.fromDto(moduleSubjectDto, subject, tutor, effects);
        majorModule.addModuleSubject(result);
        return ModuleSubjectResponse.toResponse(moduleSubjectRepository.save(result));
    }

    public void deleteModuleSubject(Long moduleSubjectId) {
        moduleSubjectRepository.delete(moduleSubjectRepository.findById(moduleSubjectId).orElseThrow(() -> {
            throw new ResourceNotFoundException("ModuleSubject", "id", moduleSubjectId);
        }));
    }
}
