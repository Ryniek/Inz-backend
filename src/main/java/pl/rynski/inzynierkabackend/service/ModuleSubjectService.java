package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.ModuleSubjectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.ModuleSubjectResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.repository.*;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

@Service
@RequiredArgsConstructor
public class ModuleSubjectService {

    private final ModuleSubjectRepository moduleSubjectRepository;
    private final FetchDataUtils fetchDataUtils;

    public ModuleSubjectResponse getModuleSubjectById(Long moduleSubjectId) {
        MajorModuleSubject result = fetchDataUtils.moduleSubjectById(moduleSubjectId);
        return ModuleSubjectResponse.toResponse(result);
    }

    public ModuleSubjectResponse addModuleSubjectToModule(Long majorModuleId, ModuleSubjectDto moduleSubjectDto) {
        MajorModule majorModule = fetchDataUtils.majorModuleById(majorModuleId);
        Subject subject = fetchDataUtils.subjectById(moduleSubjectDto.getSubjectId());
        Tutor supervisor = fetchDataUtils.tutorById(moduleSubjectDto.getSupervisorId());
        Tutor tutor = fetchDataUtils.tutorById(moduleSubjectDto.getTutorId());

        MajorModuleSubject result = ModuleSubjectDto.fromDto(moduleSubjectDto, majorModule, subject, supervisor, tutor);
        return ModuleSubjectResponse.toResponse(moduleSubjectRepository.save(result));
    }

    public void deleteModuleSubject(Long moduleSubjectId) {
        moduleSubjectRepository.delete(fetchDataUtils.moduleSubjectById(moduleSubjectId));
    }
}
