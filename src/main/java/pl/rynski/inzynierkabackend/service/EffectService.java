package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.EffectDto;
import pl.rynski.inzynierkabackend.dao.dto.EffectResponse;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.EffectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EffectService {

    private final EffectRepository effectRepository;

    public List<EffectResponse> getEffects(Boolean forSubject) {
        List<Effect> effects = effectRepository.findAllByForSubject(forSubject);
        return effects.stream().map(EffectResponse::toResponse).collect(Collectors.toList());
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
