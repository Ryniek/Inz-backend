package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.*;
import pl.rynski.inzynierkabackend.dao.dto.response.ModuleIdeaResponse;
import pl.rynski.inzynierkabackend.dao.dto.response.SubjectIdeaResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.repository.ModuleIdeaRepository;
import pl.rynski.inzynierkabackend.security.CustomUserDetailsService;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleIdeaService {

    private final CustomUserDetailsService userDetailsService;
    private final ModuleIdeaRepository moduleIdeaRepository;
    private final FetchDataUtils fetchDataUtils;

    public List<ModuleIdeaResponse> getAllModuleIdeas(Boolean approved, int page, int size) {
        Pageable sortedBySendingTime = PageRequest.of(page, size, Sort.by("sendingTime").descending());
        List<ModuleIdea> subjects = moduleIdeaRepository.findAllByApproved(approved, sortedBySendingTime);
        return subjects.stream().map(ModuleIdeaResponse::toResponse).collect(Collectors.toList());
    }

    public ModuleIdeaResponse addNewModuleIdea(NewModuleIdeaDto dto) {
        Tutor tutor = fetchDataUtils.tutorById(dto.getTutorId());
        Set<SubjectIdea> newSubjects = newSubjectDtoToSubjectIdea(dto.getNewSubjects());

        //TODO sprawdzic czy przedmiot byl juz przypisany wczesniej do danego modulu
        //TODO walidacja czy efekt jest dla przedmiotu
        Set<ModuleIdeaSubject> existingSubjects = new HashSet<>();
        dto.getExistingSubjects().forEach(subject -> {
            existingSubjects.add(createNewExistingSubject(subject));
        });

        ModuleIdea result = NewModuleIdeaDto.fromDto(dto, tutor, newSubjects, existingSubjects);
        result.setUser(userDetailsService.getLoggedUser());
        return ModuleIdeaResponse.toResponse(moduleIdeaRepository.save(result));
    }

    public ModuleIdeaResponse addChangeModuleIdea(Long majorModuleId, ChangeModuleIdeaDto dto) {
        MajorModule majorModule = fetchDataUtils.majorModuleById(majorModuleId);
        Tutor tutor = null;
        if(dto.getTutorId() != null) tutor = fetchDataUtils.tutorById(dto.getTutorId());

        Set<SubjectIdea> newSubjects = newSubjectDtoToSubjectIdea(dto.getNewSubjects());

        //TODO sprawdzic czy przedmiot byl juz przypisany wczesniej do danego modulu
        //TODO walidacja czy efekt jest dla przedmiotu
        Set<ModuleIdeaSubject> existingSubjects = new HashSet<>();
        dto.getExistingSubjects().forEach(subject -> {
            existingSubjects.add(createNewExistingSubject(subject));
        });

        ModuleIdea result = ChangeModuleIdeaDto.fromDto(dto, majorModule, tutor, newSubjects, existingSubjects);
        result.setUser(userDetailsService.getLoggedUser());
        return ModuleIdeaResponse.toResponse(moduleIdeaRepository.save(result));
    }

    public ModuleIdeaResponse addDeleteModuleIdea(DeleteModuleIdeaDto dto) {
        MajorModule majorModule = fetchDataUtils.majorModuleById(dto.getMajorModuleId());

        ModuleIdea result = DeleteModuleIdeaDto.fromDto(dto, majorModule);
        result.setUser(userDetailsService.getLoggedUser());
        return ModuleIdeaResponse.toResponse(moduleIdeaRepository.save(result));
    }

    public void deleteModuleIdea(Long moduleIdeaId) {
        moduleIdeaRepository.delete(fetchDataUtils.moduleIdeaById(moduleIdeaId));
    }

    private Set<SubjectIdea> newSubjectDtoToSubjectIdea(Set<NewSubjectIdeaDto> newSubjectDtos) {
        Set<SubjectIdea> newSubjects = new HashSet<>();
        newSubjectDtos.stream().forEach(subject -> {
            Tutor subjectTutor = fetchDataUtils.tutorById(subject.getTutorId());
            Set<SubjectIdeaEffect> effects = new HashSet<>();
            if (subject.getEffects() != null) {
                subject.getEffects().forEach(effect -> {
                    effects.add(createNewSingleEffect(effect));
                });
            }
            newSubjects.add(NewSubjectIdeaDto.fromDto(subject, null, subjectTutor, effects));
        });
        return newSubjects;
    }

    private SubjectIdeaEffect createNewSingleEffect(SubjectEffectDto effect) {
        SubjectIdeaEffect singleEffect = new SubjectIdeaEffect();
        singleEffect.setEffect(fetchDataUtils.effectById(effect.getId()));
        singleEffect.setConnectionStrength(effect.getConnectionStrength());
        return singleEffect;
    }

    private ModuleIdeaSubject createNewExistingSubject(NewModuleIdeaDto.ExistingSubject existingSubject) {
        ModuleIdeaSubject singleSubject = new ModuleIdeaSubject();
        singleSubject.setMajorModuleSubject(fetchDataUtils.moduleSubjectById(existingSubject.getModuleSubjectId()));
        singleSubject.setSemester(existingSubject.getSemester());
        return singleSubject;
    }
}
