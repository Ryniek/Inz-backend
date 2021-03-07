package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.SubjectDto;
import pl.rynski.inzynierkabackend.dao.dto.request.SubjectEffectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.SubjectResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.MajorModuleRepository;
import pl.rynski.inzynierkabackend.repository.ModuleRepository;
import pl.rynski.inzynierkabackend.repository.SubjectEffectRepository;
import pl.rynski.inzynierkabackend.repository.SubjectRepository;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectEffectRepository subjectEffectRepository;
    private final FetchDataUtils fetchDataUtils;

    public List<SubjectResponse> getSubjectsByModule(Long moduleId) {
        Module module = fetchDataUtils.moduleById(moduleId);
        return subjectRepository.findAll().stream()
                .filter(subject -> subject.getModules().contains(module))
                .map(SubjectResponse::toResponse)
                .collect(Collectors.toList());
    }

    public List<SubjectResponse> getSubjectsByEffect(Long effectId) {
        Effect effect = fetchDataUtils.effectById(effectId);
        List<SubjectEffect> subjectEffects = subjectEffectRepository.findAllByEffect(effect);
        return subjectEffects.stream().map(subjectEffect -> SubjectResponse.toResponse(subjectEffect.getSubject())).collect(Collectors.toList());
    }

    public List<SubjectResponse> getSubjects() {
        return subjectRepository.findAll().stream()
                .map(SubjectResponse::toResponse)
                .collect(Collectors.toList());
    }

    public SubjectResponse addSubject(SubjectDto dto) {
        //TODO sprawdzic czy przedmiot byl juz przypisany wczesniej do danego modulu
        //TODO walidacja czy efekt jest dla przedmiotu
        Set<SubjectEffect> effects = new HashSet<>();
        dto.getEffects().forEach(effect -> {
            effects.add(createNewSingleEffect(effect));
        });

        Subject result = SubjectDto.fromDto(dto, effects);
        return SubjectResponse.toResponse(subjectRepository.save(result));
    }

    private SubjectEffect createNewSingleEffect(SubjectEffectDto effect) {
        SubjectEffect singleEffect = new SubjectEffect();
        singleEffect.setEffect(fetchDataUtils.effectById(effect.getId()));
        singleEffect.setConnectionStrength(effect.getConnectionStrength());
        return singleEffect;
    }
}
