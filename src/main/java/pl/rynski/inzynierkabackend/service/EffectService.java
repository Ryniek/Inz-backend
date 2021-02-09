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

    private final EffectRepository eduOutcomesRepo;

    public List<EffectResponse> getEduOutcomes() {
        List<Effect> educationalOutcomes = eduOutcomesRepo.findAll();
        return educationalOutcomes.stream().map(EffectResponse::toResponse).collect(Collectors.toList());
    }

    public EffectResponse addEduOutcomes(EffectDto dto) {
        Effect effect = Effect.fromDto(dto);
        return EffectResponse.toResponse(eduOutcomesRepo.save(effect));
    }

    public void deleteDepartment(Long id) {
        eduOutcomesRepo.delete(eduOutcomesRepo.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Educational outcomes", "id", id);
        }));
    }
}
