package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.*;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.ChangeSubjectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.DeleteIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.NewSubjectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.response.SubjectIdeaResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.repository.SubjectIdeaRepository;
import pl.rynski.inzynierkabackend.security.CustomUserDetailsService;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectIdeaService {

    private final CustomUserDetailsService userDetailsService;
    private final SubjectIdeaRepository subjectIdeaRepository;
    private final FetchDataUtils fetchDataUtils;
    private final EmailService emailService;

    public List<SubjectIdeaResponse> getAllSubjectIdeas(Boolean approved, int page, int size) {
        Pageable sortedBySendingTime = PageRequest.of(page, size, Sort.by("sendingTime").descending());
        List<SubjectIdea> subjects = subjectIdeaRepository.findAllByApproved(approved, sortedBySendingTime);
        return subjects.stream().map(SubjectIdeaResponse::toResponse).collect(Collectors.toList());
    }

    public SubjectIdeaResponse respondOnSubjectIdea(Long subjectIdeaId, IdeaEmailDto ideaEmailDto) {
        SubjectIdea subjectIdea = fetchDataUtils.subjectIdeaById(subjectIdeaId);
        subjectIdea.setApproved(ideaEmailDto.getApproved());

        emailService.sendEmail(ideaEmailDto.getContent(),
                subjectIdea.getIdeaExplanation(),
                subjectIdea.getSendingTime(),
                subjectIdea.getUser().getEmail());
        return SubjectIdeaResponse.toResponse(subjectIdeaRepository.save(subjectIdea));
    }

    public SubjectIdeaResponse addChangeSubjectIdea(Long moduleSubjectDetailsId, ChangeSubjectIdeaDto dto) {
        MajorModuleSubjectDetails majorModuleSubjectDetails = fetchDataUtils.moduleSubjectDetailsById(moduleSubjectDetailsId);

        MajorModule majorModule = null;
        if(dto.getMajorModuleId() != null) majorModule = fetchDataUtils.majorModuleById(dto.getMajorModuleId());

        Tutor supervisor = null;
        if(dto.getSupervisorId() != null) supervisor = fetchDataUtils.tutorById(dto.getSupervisorId());

        Tutor tutor = null;
        if(dto.getTutorId() != null) tutor = fetchDataUtils.tutorById(dto.getTutorId());

        SubjectIdea result = ChangeSubjectIdeaDto.fromDto(dto, majorModuleSubjectDetails, majorModule, supervisor, tutor);
        result.setUser(userDetailsService.getLoggedUser());
        return SubjectIdeaResponse.toResponse(subjectIdeaRepository.save(result));
    }

    public SubjectIdeaResponse addNewSubjectIdea(NewSubjectIdeaDto dto) {
        MajorModule majorModule = fetchDataUtils.majorModuleById(dto.getMajorModuleId());
        Tutor supervisor = fetchDataUtils.tutorById(dto.getSupervisorId());
        Tutor tutor = fetchDataUtils.tutorById(dto.getTutorId());
        Set<MajorEffectSubjectIdea> majorEffects = new HashSet<>();
        dto.getMajorEffects().forEach(effect -> {
            majorEffects.add(createNewMajorEffect(effect));
        });

        SubjectIdea result = NewSubjectIdeaDto.fromDto(dto, majorModule, supervisor, tutor, majorEffects);
        result.setUser(userDetailsService.getLoggedUser());
        return SubjectIdeaResponse.toResponse(subjectIdeaRepository.save(result));
    }

    public SubjectIdeaResponse addDeleteSubjectIdea(DeleteIdeaDto dto) {
        MajorModuleSubjectDetails majorModuleSubjectDetails = fetchDataUtils.moduleSubjectDetailsById(dto.getElementId());

        SubjectIdea result = DeleteIdeaDto.fromDto(dto, majorModuleSubjectDetails);
        result.setUser(userDetailsService.getLoggedUser());
        return SubjectIdeaResponse.toResponse(subjectIdeaRepository.save(result));
    }

    public void deleteSubjectIdea(Long subjectIdeaId) {
        subjectIdeaRepository.delete(fetchDataUtils.subjectIdeaById(subjectIdeaId));
    }

    private MajorEffectSubjectIdea createNewMajorEffect(NewSubjectIdeaDto.MajorEffectIdDto effect) {
        MajorEffectSubjectIdea majorEffectSubjectIdea = new MajorEffectSubjectIdea();
        majorEffectSubjectIdea.setMajorEffect(fetchDataUtils.majorEffectById(effect.getMajorEffectId()));
        majorEffectSubjectIdea.setConnectionStrength(effect.getConnectionStrength());
        return majorEffectSubjectIdea;
    }
}
