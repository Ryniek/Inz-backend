package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.EffectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.EffectResponse;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.EffectRepository;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EffectService {

    private final EffectRepository effectRepository;
    private final FetchDataUtils fetchDataUtils;

    public List<EffectResponse> getEffects(Boolean forSubject) {
        List<Effect> effects = effectRepository.findAllByForSubject(forSubject);
        return effects.stream().map(EffectResponse::toResponse).collect(Collectors.toList());
    }

    public EffectResponse getEffectById(Long effectId) {
        Effect effect = fetchDataUtils.effectById(effectId);
        return EffectResponse.toResponse(effect);
    }

    public EffectResponse addEffect(EffectDto dto) {
        Effect effect = EffectDto.fromDto(dto);
        return EffectResponse.toResponse(effectRepository.save(effect));
    }

    public void deleteEffect(Long id) {
        effectRepository.delete(effectRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Effect", "id", id);
        }));
    }
}
