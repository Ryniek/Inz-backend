package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.*;
import pl.rynski.inzynierkabackend.dao.dto.response.ModuleIdeaResponse;
import pl.rynski.inzynierkabackend.dao.dto.response.SubjectIdeaResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.repository.EffectIdeaRepository;
import pl.rynski.inzynierkabackend.repository.MajorRepository;
import pl.rynski.inzynierkabackend.repository.ModuleSubjectRepository;
import pl.rynski.inzynierkabackend.security.CustomUserDetailsService;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EffectIdeaService {

    private final EffectIdeaRepository effectIdeaRepository;
    private final ModuleSubjectRepository moduleSubjectRepository;
    private final MajorRepository majorRepository;
    private final EmailService emailService;
    private final FetchDataUtils fetchDataUtils;
    private final CustomUserDetailsService userDetailsService;

    public String getAllEffectIdeas(Boolean approved, int page, int size) {

        return null;
    }

    //TODO Response
    public String respondOnEffectIdea(Long effectIdeaId, IdeaEmailDto ideaEmailDto) {
        EffectIdea effectIdea = fetchDataUtils.effectIdeaById(effectIdeaId);
        effectIdea.setApproved(ideaEmailDto.getApproved());

        emailService.sendEmail(ideaEmailDto.getContent(),
                effectIdea.getIdeaExplanation(),
                effectIdea.getSendingTime(),
                effectIdea.getUser().getEmail());

        effectIdeaRepository.save(effectIdea);
        return null;
        //return
    }

    public void addNewEffectIdea(NewEffectIdeaDto dto) {
        //TODO sprawdzic czy przedmiot byl juz przypisany wczesniej do danego modulu
        //TODO walidacja czy efekt jest dla przedmiotu
        Set<SubjectEffectIdea> subjects = new HashSet<>();
        dto.getSubjects().forEach(subject -> {
            subjects.add(createNewSingleSubject(subject));
        });
        List<Major> majors = new ArrayList<>();
        if(!dto.getMajorIds().isEmpty()) {
            majors = majorRepository.findAllById(dto.getMajorIds());
        }

        EffectIdea result = NewEffectIdeaDto.fromDto(dto, subjects, majors);
        result.setUser(userDetailsService.getLoggedUser());
        effectIdeaRepository.save(result);
        //return ModuleIdeaResponse.toResponse(moduleIdeaRepository.save(result));
    }

    public void addChangeEffectIdea(Long effectId, ChangeEffectIdeaDto dto) {
        Effect effect = fetchDataUtils.effectById(effectId);

        Set<SubjectEffectIdea> subjects = new HashSet<>();
        dto.getExistingSubjects().forEach(subject -> {
            subjects.add(createNewSingleSubject(subject));
        });

        List<Major> majors = new ArrayList<>();
        if(!dto.getMajorIds().isEmpty()) {
            majors = majorRepository.findAllById(dto.getMajorIds());
        }

        EffectIdea result = ChangeEffectIdeaDto.fromDto(dto, majors, subjects);
        result.setUser(userDetailsService.getLoggedUser());
        effectIdeaRepository.save(result);
        //return SubjectIdeaResponse.toResponse(subjectIdeaRepository.save(result));
    }

    public void addDeleteEffectIdea(DeleteIdeaDto dto) {
        Effect effect = fetchDataUtils.effectById(dto.getIdeaId());

        EffectIdea result = DeleteIdeaDto.fromDto(dto, effect);
        result.setUser(userDetailsService.getLoggedUser());
        effectIdeaRepository.save(result);
        //return SubjectIdeaResponse.toResponse(subjectIdeaRepository.save(result));
    }

    public void deleteEffectIdea(Long effectIdeaId) {
        effectIdeaRepository.delete(fetchDataUtils.effectIdeaById(effectIdeaId));
    }

    private SubjectEffectIdea createNewSingleSubject(SubjectEffectDto effect) {
        SubjectEffectIdea singleSubject = new SubjectEffectIdea();
        singleSubject.setMajorModuleSubject(fetchDataUtils.moduleSubjectById(effect.getId()));
        singleSubject.setConnectionStrength(effect.getConnectionStrength());
        return singleSubject;
    }
}
