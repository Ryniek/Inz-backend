package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.MajorModuleDto;
import pl.rynski.inzynierkabackend.dao.dto.response.MajorModuleResponse;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.dao.model.Tutor;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.MajorModuleRepository;
import pl.rynski.inzynierkabackend.repository.MajorRepository;
import pl.rynski.inzynierkabackend.repository.ModuleRepository;
import pl.rynski.inzynierkabackend.repository.TutorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorModuleService {

    private final MajorModuleRepository majorModuleRepository;
    private final MajorRepository majorRepository;
    private final ModuleRepository moduleRepository;
    private final TutorRepository tutorRepository;

    public List<MajorModuleResponse> getModulesByMajor(Long majorId) {
        Major major = majorRepository.findById(majorId)
                .orElseThrow(() -> new ResourceNotFoundException("Major", "id", majorId));
        return majorModuleRepository.findAllByMajor(major).stream()
                .map(MajorModuleResponse::toResponse)
                .collect(Collectors.toList());
    }

    public MajorModuleResponse assingModuleToMajor(MajorModuleDto majorModuleDto) {
        //TODO sprawdzic czy modul o takim id nie jest juz przypisany, jesli jest to zwrocic jakas odpowiedz
        Major major = majorRepository.findById(majorModuleDto.getMajorId())
                .orElseThrow(() -> new ResourceNotFoundException("Major", "id", majorModuleDto.getMajorId()));
        Module module = moduleRepository.findById(majorModuleDto.getModuleId())
                .orElseThrow(() -> new ResourceNotFoundException("Module", "id", majorModuleDto.getModuleId()));
        Tutor tutor = tutorRepository.findById(majorModuleDto.getTutorId())
                .orElseThrow(() -> new ResourceNotFoundException("Tutor", "id", majorModuleDto.getTutorId()));
        MajorModule result = majorModuleRepository.save(MajorModuleDto.fromDto(major, module, tutor));
        return MajorModuleResponse.toResponse(result);
    }

    public void deleteMajorModule(Long majorModuleId) {
        majorModuleRepository.delete(majorModuleRepository.findById(majorModuleId).orElseThrow(() -> {
            throw new ResourceNotFoundException("MajorModule", "id", majorModuleId);
        }));
    }
}
