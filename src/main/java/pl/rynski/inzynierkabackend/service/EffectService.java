package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.MajorEffectDto;
import pl.rynski.inzynierkabackend.dao.dto.request.SubjectEffectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.EffectResponse;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.dao.model.SubjectEffect;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.MajorEffectRepository;
import pl.rynski.inzynierkabackend.repository.SubjectEffectRepository;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EffectService {

    private final FetchDataUtils fetchDataUtils;
    private final MajorEffectRepository majorEffectRepository;
    private final SubjectEffectRepository subjectEffectRepository;

    public List<EffectResponse> getEffects(Boolean forSubject) {
        if(forSubject) {
            List<SubjectEffect> subjectEffects = subjectEffectRepository.findAll();
            return subjectEffects.stream().map(EffectResponse::toResponse).collect(Collectors.toList());
        } else {
            List<MajorEffect> majorEffects = majorEffectRepository.findAll();
            return majorEffects.stream().map(EffectResponse::toResponse).collect(Collectors.toList());
        }
    }

    public List<EffectResponse> getEffectsByMajor(Long majorId) {
        List<MajorEffect> majorEffects = majorEffectRepository.findAllByMajors_Id(majorId);
        return majorEffects.stream().map(EffectResponse::toResponse).collect(Collectors.toList());
    }

    public EffectResponse getEffectById(Long effectId, Boolean forSubject) {
        if(forSubject) {
            SubjectEffect subjectEffect = fetchDataUtils.subjectEffectById(effectId);
            return EffectResponse.toResponse(subjectEffect);
        } else {
            MajorEffect majorEffect = fetchDataUtils.majorEffectById(effectId);
            return EffectResponse.toResponse(majorEffect);
        }
    }

    public EffectResponse addMajorEffect(MajorEffectDto dto, Long majorId) {
        Major major = fetchDataUtils.majorById(majorId);
        MajorEffect majorEffect = MajorEffectDto.fromDto(dto, major);
        return EffectResponse.toResponse(majorEffectRepository.save(majorEffect));
    }

    public EffectResponse addSubjectEffect(SubjectEffectDto dto) {
        List<MajorEffect> majorEffects = majorEffectRepository.findAllById(dto.getMajorEffects());
        SubjectEffect subjectEffect = SubjectEffectDto.fromDto(dto, new HashSet<>(majorEffects));
        return EffectResponse.toResponse(subjectEffectRepository.save(subjectEffect));
    }
}
