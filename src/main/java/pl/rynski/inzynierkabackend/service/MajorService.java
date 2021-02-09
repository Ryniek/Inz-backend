package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.MajorDto;
import pl.rynski.inzynierkabackend.dao.dto.MajorResponse;
import pl.rynski.inzynierkabackend.dao.model.Department;
import pl.rynski.inzynierkabackend.dao.model.Effect;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.exception.ResourceNotFoundException;
import pl.rynski.inzynierkabackend.repository.DepartmentRepository;
import pl.rynski.inzynierkabackend.repository.EffectRepository;
import pl.rynski.inzynierkabackend.repository.MajorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorService {
    private final MajorRepository majorRepository;
    private final DepartmentRepository departmentRepository;
    private final EffectRepository effectRepository;

    public List<MajorResponse> getMajorsByDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId));
        List<Major> majors = majorRepository.findAllByDepartment(department);
        return majors.stream().map(MajorResponse::toResponse).collect(Collectors.toList());
    }

    public MajorResponse addMajor(MajorDto dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", dto.getDepartmentId()));
        List<Effect> effects = effectRepository.findByIdsAndForMajor(dto.getEffects());
        Major major = MajorDto.fromDto(dto);
        major.setDepartment(department);
        major.setEffects(new HashSet<>(effects));
        return MajorResponse.toResponse(majorRepository.save(major));
    }

    public MajorResponse toggleMajorVisibility(Long majorId) {
        Major major = majorRepository.findById(majorId)
                .orElseThrow(() -> new ResourceNotFoundException("Major", "id", majorId));
        major.setHidden(!major.getHidden());
        return MajorResponse.toResponse(majorRepository.save(major));
    }

    public void deleteMajor(Long majorId) {
        majorRepository.delete(majorRepository.findById(majorId).orElseThrow(() -> {
            throw new ResourceNotFoundException("Major", "id", majorId);
        }));
    }
}
