package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.ModuleDto;
import pl.rynski.inzynierkabackend.dao.dto.SubjectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.ModuleResponse;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.dao.model.Subject;
import pl.rynski.inzynierkabackend.repository.ModuleRepository;
import pl.rynski.inzynierkabackend.repository.SubjectRepository;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final SubjectRepository subjectRepository;
    private final FetchDataUtils fetchDataUtils;

    public List<ModuleResponse> getModules() {
        return moduleRepository.findAll().stream()
                .map(ModuleResponse::toResponse)
                .collect(Collectors.toList());
    }

    public ModuleResponse addModule(ModuleDto moduleDto) {
        Module module = ModuleDto.fromDto(moduleDto);
        return ModuleResponse.toResponse(moduleRepository.save(module));
    }

    public ModuleResponse addSubjectToModule(Long moduleId, Long subjectId) {
        Module module = fetchDataUtils.moduleById(moduleId);
        Subject subject = fetchDataUtils.subjectById(subjectId);
        module.addSubject(subject);
        return ModuleResponse.toResponse(moduleRepository.save(module));
    }

    public ModuleResponse removeSubjectFromModule(Long moduleId, Long subjectId) {
        Module module = fetchDataUtils.moduleById(moduleId);
        Subject subject = fetchDataUtils.subjectById(subjectId);
        module.removeSubject(subject);
        return ModuleResponse.toResponse(moduleRepository.save(module));
    }
}
