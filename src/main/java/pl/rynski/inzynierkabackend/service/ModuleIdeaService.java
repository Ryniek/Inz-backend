package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.*;
import pl.rynski.inzynierkabackend.dao.dto.response.ModuleIdeaResponse;
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
    private final EmailService emailService;

    public List<ModuleIdeaResponse> getAllModuleIdeas(Boolean approved, int page, int size) {
        Pageable sortedBySendingTime = PageRequest.of(page, size, Sort.by("sendingTime").descending());
        List<ModuleIdea> subjects = moduleIdeaRepository.findAllByApproved(approved, sortedBySendingTime);
        return subjects.stream().map(ModuleIdeaResponse::toResponse).collect(Collectors.toList());
    }

    public ModuleIdeaResponse respondOnModuleIdea(Long moduleIdeaId, IdeaEmailDto ideaEmailDto) {
        ModuleIdea moduleIdea = fetchDataUtils.moduleIdeaById(moduleIdeaId);
        moduleIdea.setApproved(ideaEmailDto.getApproved());

        emailService.sendEmail(ideaEmailDto.getContent(),
                moduleIdea.getIdeaExplanation(),
                moduleIdea.getSendingTime(),
                moduleIdea.getUser().getEmail());
        return ModuleIdeaResponse.toResponse(moduleIdeaRepository.save(moduleIdea));
    }

    public ModuleIdeaResponse addNewModuleIdea(NewModuleIdeaDto dto) {
        Tutor tutor = fetchDataUtils.tutorById(dto.getTutorId());
        Major major = fetchDataUtils.majorById(dto.getMajorId());
        Set<SubjectIdea> newSubjects = new HashSet<>();
        //TODO sprawdzic czy przedmiot byl juz przypisany wczesniej do danego modulu
        //TODO walidacja czy efekt jest dla przedmiotu
        Set<ModuleIdeaSubject> existingSubjects = new HashSet<>();
        dto.getExistingSubjects().forEach(subject -> {
            existingSubjects.add(createNewExistingSubject(subject));
        });

        ModuleIdea result = NewModuleIdeaDto.fromDto(dto, tutor, major, newSubjects, existingSubjects);
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
        //TODO existing subjects mi sie nie podoba - ten semester sprawdzic czy jak dam nulla to nie wywala

        ModuleIdea result = ChangeModuleIdeaDto.fromDto(dto, majorModule, tutor, newSubjects, existingSubjects);
        result.setUser(userDetailsService.getLoggedUser());
        return ModuleIdeaResponse.toResponse(moduleIdeaRepository.save(result));
    }

    public ModuleIdeaResponse addDeleteModuleIdea(DeleteIdeaDto dto) {
        MajorModule majorModule = fetchDataUtils.majorModuleById(dto.getIdeaId());

        ModuleIdea result = DeleteIdeaDto.fromDto(dto, majorModule);
        result.setUser(userDetailsService.getLoggedUser());
        return ModuleIdeaResponse.toResponse(moduleIdeaRepository.save(result));
    }

    public void deleteModuleIdea(Long moduleIdeaId) {
        moduleIdeaRepository.delete(fetchDataUtils.moduleIdeaById(moduleIdeaId));
    }

    private Set<SubjectIdea> newSubjectDtoToSubjectIdea(Set<NewSubjectIdeaDto> newSubjectDtos) {
        Set<SubjectIdea> newSubjects = new HashSet<>();
        newSubjectDtos.stream().forEach(subject -> {
            Tutor supervisor = fetchDataUtils.tutorById(subject.getSupervisorId());
            Tutor subjectTutor = fetchDataUtils.tutorById(subject.getTutorId());
            newSubjects.add(NewSubjectIdeaDto.fromDto(subject, null, supervisor, subjectTutor));
        });
        return newSubjects;
    }

    private ModuleIdeaSubject createNewExistingSubject(NewModuleIdeaDto.ExistingSubject existingSubject) {
        ModuleIdeaSubject singleSubject = new ModuleIdeaSubject();
        singleSubject.setSubject(fetchDataUtils.subjectById(existingSubject.getSubjectId()));
        singleSubject.setTutor(fetchDataUtils.tutorById(existingSubject.getTutorId()));
        singleSubject.setEcts(existingSubject.getEcts());
        return singleSubject;
    }
}
