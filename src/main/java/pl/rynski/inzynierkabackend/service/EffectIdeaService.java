package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.*;
import pl.rynski.inzynierkabackend.dao.dto.response.EffectIdeaResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.repository.EffectIdeaRepository;
import pl.rynski.inzynierkabackend.repository.MajorRepository;
import pl.rynski.inzynierkabackend.security.CustomUserDetailsService;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EffectIdeaService {

    private final EffectIdeaRepository effectIdeaRepository;
    private final MajorRepository majorRepository;
    private final EmailService emailService;
    private final FetchDataUtils fetchDataUtils;
    private final CustomUserDetailsService userDetailsService;

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
        Subject subject = null;
        if(dto.getForSubject()) {
            subject = fetchDataUtils.subjectById(dto.getSubjectId());
        }

        Major major = null;
        Set<EffectIdeaSubject> effectIdeaSubjects = new HashSet<>();
        if(dto.getForMajor()) {
            major = fetchDataUtils.majorById(dto.getMajorId());
            dto.getMajorEffectSubjects().forEach(effect -> {
                effectIdeaSubjects.add(createMajorEffectSubject(effect));
            });
        }

        EffectIdea result = NewEffectIdeaDto.fromDto(dto, subject, major, effectIdeaSubjects);
        result.setUser(userDetailsService.getLoggedUser());
        return EffectIdeaResponse.toResponse(effectIdeaRepository.save(result));
    }

/*    public EffectIdeaResponse addChangeEffectIdea(Long effectId, ChangeEffectIdeaDto dto) {
        Effect effect = fetchDataUtils.effectById(effectId);

        Set<SubjectEffectIdea> subjects = new HashSet<>();
        dto.getExistingSubjects().forEach(subject -> {
            subjects.add(createNewSingleSubject(subject));
        });

        List<Major> majors = new ArrayList<>();
        if(!dto.getMajorIds().isEmpty()) {
            majors = majorRepository.findAllById(dto.getMajorIds());
        }

        EffectIdea result = ChangeEffectIdeaDto.fromDto(dto, effect, majors, subjects);
        result.setUser(userDetailsService.getLoggedUser());
        return EffectIdeaResponse.toResponse(effectIdeaRepository.save(result));
    }*/

    public EffectIdeaResponse addDeleteEffectIdea(DeleteIdeaDto dto, Boolean forSubject) {
        EffectIdea result = null;
        if(forSubject) {
            SubjectEffect subjectEffect = fetchDataUtils.subjectEffectById(dto.getIdeaId());
            result = DeleteIdeaDto.fromDto(dto, subjectEffect);
            result.setUser(userDetailsService.getLoggedUser());

        } else {
            MajorEffect majorEffect = fetchDataUtils.majorEffectById(dto.getIdeaId());
            result = DeleteIdeaDto.fromDto(dto, majorEffect);
            result.setUser(userDetailsService.getLoggedUser());
        }

        return EffectIdeaResponse.toResponse(effectIdeaRepository.save(result));
    }

    public void deleteEffectIdea(Long effectIdeaId) {
        effectIdeaRepository.delete(fetchDataUtils.effectIdeaById(effectIdeaId));
    }

/*    private SubjectEffectIdea createNewSingleSubject(SubjectEffectDto effect) {
        SubjectEffectIdea singleSubject = new SubjectEffectIdea();
        singleSubject.setSubject(fetchDataUtils.subjectById(effect.getId()));
        singleSubject.setConnectionStrength(effect.getConnectionStrength());
        return singleSubject;
    }*/

    private EffectIdeaSubject createMajorEffectSubject(NewEffectIdeaDto.MajorEffectSubjectDto dto) {
        EffectIdeaSubject result = new EffectIdeaSubject();
        result.setSubject(fetchDataUtils.subjectById(dto.getSubjectId()));
        result.setConnectionStrength(dto.getConnectionStrength());
        return result;
    }
}
