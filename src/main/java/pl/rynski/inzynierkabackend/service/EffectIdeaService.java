package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.*;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.ChangeEffectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.DeleteIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.request.ideas.NewEffectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.response.EffectIdeaResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.repository.EffectIdeaRepository;
import pl.rynski.inzynierkabackend.repository.MajorRepository;
import pl.rynski.inzynierkabackend.repository.SubjectRepository;
import pl.rynski.inzynierkabackend.security.CustomUserDetailsService;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EffectIdeaService {

    private final EffectIdeaRepository effectIdeaRepository;
    private final MajorRepository majorRepository;
    private final EmailService emailService;
    private final FetchDataUtils fetchDataUtils;
    private final CustomUserDetailsService userDetailsService;
    private final SubjectRepository subjectRepository;

    public List<EffectIdeaResponse> getAllEffectIdeas(Boolean approved, int page, int size) {
        Pageable sortedBySendingTime = PageRequest.of(page, size, Sort.by("sendingTime").descending());
        List<EffectIdea> effects = effectIdeaRepository.findAllByApproved(approved, sortedBySendingTime);
        return effects.stream().map(EffectIdeaResponse::toResponse).collect(Collectors.toList());
    }

    public EffectIdeaResponse respondOnEffectIdea(Long effectIdeaId, IdeaEmailDto ideaEmailDto) {
        EffectIdea effectIdea = fetchDataUtils.effectIdeaById(effectIdeaId);
        effectIdea.setApproved(ideaEmailDto.getApproved());

        emailService.sendEmail(ideaEmailDto.getContent(),
                effectIdea.getIdeaExplanation(),
                effectIdea.getSendingTime(),
                effectIdea.getUser().getEmail());

        return EffectIdeaResponse.toResponse(effectIdeaRepository.save(effectIdea));
    }

    public EffectIdeaResponse addNewEffectIdea(NewEffectIdeaDto dto) {
        Major major = fetchDataUtils.majorById(dto.getMajorId());

        EffectIdea result = NewEffectIdeaDto.fromDto(dto, major);
        result.setUser(userDetailsService.getLoggedUser());
        return EffectIdeaResponse.toResponse(effectIdeaRepository.save(result));
    }

    public EffectIdeaResponse addChangeEffectIdea(Long effectId, ChangeEffectIdeaDto dto) {
        MajorEffect majorEffect = fetchDataUtils.majorEffectById(effectId);
        Major major = fetchDataUtils.majorById(dto.getMajorId());

        Set<EffectIdeaModuleSubject> majorEffectSubjects = new HashSet<>();
        dto.getMajorEffectSubjects().forEach(subject -> {
            majorEffectSubjects.add(createMajorEffectSubject(subject));
        });

        EffectIdea result = ChangeEffectIdeaDto.fromDto(dto, majorEffect, major, majorEffectSubjects);
        result.setUser(userDetailsService.getLoggedUser());
        return EffectIdeaResponse.toResponse(effectIdeaRepository.save(result));
    }

    public EffectIdeaResponse addDeleteEffectIdea(DeleteIdeaDto dto) {
        MajorEffect majorEffect = fetchDataUtils.majorEffectById(dto.getElementId());

        EffectIdea result = DeleteIdeaDto.fromDto(dto, majorEffect);
        result.setUser(userDetailsService.getLoggedUser());
        return EffectIdeaResponse.toResponse(effectIdeaRepository.save(result));
    }

    public void deleteEffectIdea(Long effectIdeaId) {
        effectIdeaRepository.delete(fetchDataUtils.effectIdeaById(effectIdeaId));
    }

    private EffectIdeaModuleSubject createMajorEffectSubject(MajorEffectConnectionDto dto) {
        EffectIdeaModuleSubject result = new EffectIdeaModuleSubject();
        result.setMajorModuleSubject(fetchDataUtils.moduleSubjectById(dto.getId()));
        result.setConnectionStrength(dto.getConnectionStrength());
        return result;
    }
}
