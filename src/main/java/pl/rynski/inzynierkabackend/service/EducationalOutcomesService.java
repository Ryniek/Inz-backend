package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.EduOutcomesDto;
import pl.rynski.inzynierkabackend.dao.dto.EduOutcomesResponse;
import pl.rynski.inzynierkabackend.dao.model.EducationalOutcomes;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.EducationalOutcomesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationalOutcomesService {

    private final EducationalOutcomesRepository eduOutcomesRepo;

    public List<EduOutcomesResponse> getEduOutcomes() {
        List<EducationalOutcomes> educationalOutcomes = eduOutcomesRepo.findAll();
        return educationalOutcomes.stream().map(EduOutcomesResponse::toResponse).collect(Collectors.toList());
    }

    public EduOutcomesResponse addEduOutcomes(EduOutcomesDto dto) {
        EducationalOutcomes educationalOutcomes = EducationalOutcomes.fromDto(dto);
        return EduOutcomesResponse.toResponse(eduOutcomesRepo.save(educationalOutcomes));
    }

    public void deleteDepartment(Long id) {
        eduOutcomesRepo.delete(eduOutcomesRepo.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Educational outcomes", "id", id);
        }));
    }
}
