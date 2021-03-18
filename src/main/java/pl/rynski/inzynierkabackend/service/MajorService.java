package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.MajorDto;
import pl.rynski.inzynierkabackend.dao.dto.response.MajorResponse;
import pl.rynski.inzynierkabackend.dao.model.Department;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorEffect;
import pl.rynski.inzynierkabackend.repository.MajorEffectRepository;
import pl.rynski.inzynierkabackend.repository.MajorRepository;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorService {

    private final MajorRepository majorRepository;
    private final FetchDataUtils fetchDataUtils;
    private final MajorEffectRepository majorEffectRepository;

    public List<MajorResponse> getNotHiddenMajors() {
        List<Major> majors = majorRepository.findAllByHidden(false);
        return majors.stream().map(MajorResponse::toResponse).collect(Collectors.toList());
    }

    public List<MajorResponse> getMajorsByDepartment(Long departmentId, Boolean hidden) {
        Department department = fetchDataUtils.departmentById(departmentId);
        List<Major> majors;
        if(hidden != null) majors = majorRepository.findAllByDepartmentAndHidden(department, hidden);
        else majors = majorRepository.findAllByDepartment(department);
        return majors.stream().map(MajorResponse::toResponse).collect(Collectors.toList());
    }

    public MajorResponse getMajorById(Long majorId) {
        Major major = fetchDataUtils.majorById(majorId);
        return MajorResponse.toResponse(major);
    }

    public MajorResponse addMajor(MajorDto dto) {
        Department department = fetchDataUtils.departmentById(dto.getDepartmentId());
        List<MajorEffect> majorEffects = majorEffectRepository.findAllById(dto.getMajorEffects());
        Major major = MajorDto.fromDto(dto, department, majorEffects);
        return MajorResponse.toResponse(majorRepository.save(major));
    }

    public MajorResponse toggleMajorVisibility(Long majorId) {
        Major major = fetchDataUtils.majorById(majorId);
        major.setHidden(!major.getHidden());
        return MajorResponse.toResponse(majorRepository.save(major));
    }

    public void deleteMajor(Long majorId) {
        majorRepository.delete(fetchDataUtils.majorById(majorId));
    }
}
