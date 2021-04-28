package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.EffectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.EffectResponse;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.repository.MajorEffectRepository;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EffectService {

    private final FetchDataUtils fetchDataUtils;
    private final MajorEffectRepository majorEffectRepository;

    public List<EffectResponse> getMajorEffects() {
        List<MajorEffect> majorEffects = majorEffectRepository.findAll();
        return majorEffects.stream().map(EffectResponse::toResponse).collect(Collectors.toList());
    }

    public List<EffectResponse> getEffectsByMajor(Long majorId) {
        List<MajorEffect> majorEffects = majorEffectRepository.findAllByMajors_Id(majorId);
        return majorEffects.stream().map(EffectResponse::toResponse).collect(Collectors.toList());
    }

    public EffectResponse getMajorEffectById(Long effectId) {
        MajorEffect majorEffect = fetchDataUtils.majorEffectById(effectId);
        return EffectResponse.toResponse(majorEffect);
    }

    public EffectResponse addMajorEffect(EffectDto dto, Long majorId) {
        Major major = fetchDataUtils.majorById(majorId);
        MajorEffect majorEffect = EffectDto.fromDto(dto, major);
        return EffectResponse.toResponse(majorEffectRepository.save(majorEffect));
    }
}
