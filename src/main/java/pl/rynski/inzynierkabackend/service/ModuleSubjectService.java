package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.MajorEffectConnectionDto;
import pl.rynski.inzynierkabackend.dao.dto.request.ModuleSubjectDetailsDto;
import pl.rynski.inzynierkabackend.dao.dto.request.ModuleSubjectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.ModuleSubjectResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.repository.*;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ModuleSubjectService {

    private final ModuleSubjectRepository moduleSubjectRepository;
    private final ModuleSubjectDetailsRepository moduleSubjectDetailsRepository;
    private final FetchDataUtils fetchDataUtils;

    public ModuleSubjectResponse getModuleSubjectById(Long moduleSubjectId) {
        MajorModuleSubject result = fetchDataUtils.moduleSubjectById(moduleSubjectId);
        return ModuleSubjectResponse.toResponse(result);
    }

    public ModuleSubjectResponse addModuleSubjectToModule(Long majorModuleId, ModuleSubjectDto moduleSubjectDto) {
        MajorModule majorModule = fetchDataUtils.majorModuleById(majorModuleId);
        Subject subject = fetchDataUtils.subjectById(moduleSubjectDto.getSubjectId());
        Tutor supervisor = fetchDataUtils.tutorById(moduleSubjectDto.getSupervisorId());

        Set<MajorEffectModuleSubject> majorEffects = new HashSet<>();
        moduleSubjectDto.getMajorEffects().forEach(majorEffect -> {
            majorEffects.add(createMajorEffectFromDto(majorEffect));
        });

        MajorModuleSubject result = ModuleSubjectDto.fromDto(moduleSubjectDto, majorModule, subject, supervisor, majorEffects);
        return ModuleSubjectResponse.toResponse(moduleSubjectRepository.save(result));
    }

    //TODO Sprawdzic czy dobrze zwraca
    public ModuleSubjectResponse addSubjectDetailsToModuleSubject(Long majorModuleSubjectId, ModuleSubjectDetailsDto dto) {
        MajorModuleSubject majorModuleSubject = fetchDataUtils.moduleSubjectById(majorModuleSubjectId);
        Tutor tutor = fetchDataUtils.tutorById(dto.getTutorId());

        MajorModuleSubjectDetails result = ModuleSubjectDetailsDto.fromDto(dto, majorModuleSubject, tutor);
        result = moduleSubjectDetailsRepository.save(result);
        return ModuleSubjectResponse.toResponse(result.getMajorModuleSubject());
    }

    public void deleteModuleSubject(Long moduleSubjectId) {
        moduleSubjectRepository.delete(fetchDataUtils.moduleSubjectById(moduleSubjectId));
    }

    public void deleteModuleSubjectDetails(Long moduleSubjectDetailsId) {
        moduleSubjectDetailsRepository.delete(fetchDataUtils.moduleSubjectDetailsById(moduleSubjectDetailsId));
    }

    private MajorEffectModuleSubject createMajorEffectFromDto(MajorEffectConnectionDto dto) {
        MajorEffectModuleSubject result = new MajorEffectModuleSubject();
        result.setMajorEffect(fetchDataUtils.majorEffectById(dto.getId()));
        result.setConnectionStrength(dto.getConnectionStrength());
        return result;
    }
}
