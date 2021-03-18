package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.MajorEffectDto;
import pl.rynski.inzynierkabackend.dao.dto.request.SubjectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.SubjectResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.Module;
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
    private final FetchDataUtils fetchDataUtils;
    private final SubjectEffectRepository subjectEffectRepository;

    public List<SubjectResponse> getSubjectsByModule(Long moduleId) {
        Module module = fetchDataUtils.moduleById(moduleId);
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

    public SubjectResponse addSubject(SubjectDto dto) {
        Set<MajorEffectSubject> majorEffects = new HashSet<>();
        dto.getMajorEffects().forEach(effect -> {
            majorEffects.add(createNewMajorEffect(effect));
        });

        List<SubjectEffect> subjectEffects = subjectEffectRepository.findAllById(dto.getSubjectEffects());

        Subject result = SubjectDto.fromDto(dto, majorEffects, new HashSet<>(subjectEffects));
        return SubjectResponse.toResponse(subjectRepository.save(result));
    }

    private MajorEffectSubject createNewMajorEffect(SubjectDto.MajorEffectDto effect) {
        MajorEffectSubject majorEffectSubject = new MajorEffectSubject();
        majorEffectSubject.setMajorEffect(fetchDataUtils.majorEffectById(effect.getMajorEffectId()));
        majorEffectSubject.setConnectionStrength(effect.getConnectionStrength());
        return majorEffectSubject;
    }
}
