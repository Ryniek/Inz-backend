package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.SubjectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.SubjectResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.repository.SubjectEffectRepository;
import pl.rynski.inzynierkabackend.repository.SubjectRepository;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final FetchDataUtils fetchDataUtils;

    public List<SubjectResponse> getSubjectsByModule(Long moduleId) {
        Module module = fetchDataUtils.moduleById(moduleId);
        return subjectRepository.findAll().stream()
                .filter(subject -> subject.getModules().contains(module))
                .map(SubjectResponse::toResponse)
                .collect(Collectors.toList());
    }


    public List<SubjectResponse> getSubjects() {
        return subjectRepository.findAll().stream()
                .map(SubjectResponse::toResponse)
                .collect(Collectors.toList());
    }

    public SubjectResponse addSubject(SubjectDto dto) {
        Subject result = SubjectDto.fromDto(dto);
        return SubjectResponse.toResponse(subjectRepository.save(result));
    }
}
