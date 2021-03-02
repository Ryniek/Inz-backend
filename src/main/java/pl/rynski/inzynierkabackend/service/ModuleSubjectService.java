package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.ModuleSubjectDto;
import pl.rynski.inzynierkabackend.dao.dto.SubjectEffectDto;
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
    private final FetchDataUtils fetchDataUtils;

    public ModuleSubjectResponse addModuleSubjectToModule(Long majorModuleId, ModuleSubjectDto moduleSubjectDto) {
        MajorModule majorModule = fetchDataUtils.majorModuleById(majorModuleId);
        Subject subject = fetchDataUtils.subjectById(moduleSubjectDto.getSubjectId());
        Tutor tutor = fetchDataUtils.tutorById(moduleSubjectDto.getTutorId());

        MajorModuleSubject result = ModuleSubjectDto.fromDto(moduleSubjectDto, majorModule, subject, tutor);
        return ModuleSubjectResponse.toResponse(moduleSubjectRepository.save(result));
    }

    public void deleteModuleSubject(Long moduleSubjectId) {
        moduleSubjectRepository.delete(fetchDataUtils.moduleSubjectById(moduleSubjectId));
    }
}
