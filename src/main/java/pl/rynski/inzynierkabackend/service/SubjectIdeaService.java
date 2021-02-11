package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.ChangeSubjectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.DeleteSubjectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.NewSubjectIdeaDto;
import pl.rynski.inzynierkabackend.dao.dto.SubjectEffectDto;
import pl.rynski.inzynierkabackend.dao.dto.response.SubjectIdeaResponse;
import pl.rynski.inzynierkabackend.dao.model.*;
import pl.rynski.inzynierkabackend.repository.SubjectIdeaRepository;
import pl.rynski.inzynierkabackend.security.CustomUserDetailsService;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubjectIdeaService {

    private final CustomUserDetailsService userDetailsService;
    private final SubjectIdeaRepository subjectIdeaRepository;
    private final FetchDataUtils fetchDataUtils;

    //TODO sprawdzanie tych nulli przy Response

    //TODO odpowiadanie(zaznaczanie na approved/nieapproved, wysylanie maila do usera)
    //TODO info mailowe o nowym zgloszeniu do kazdego admina?(do kazdego admina i do usera z potwierdzeniem wyslania sugestii)

    //TODO paginacja, podział na odpowiedziane/nieodpowiedziane
    public List<SubjectIdeaResponse> getAllSubjectIdeas() {
        return null;
    }

    public SubjectIdeaResponse addChangeSubjectIdea(Long moduleSubjectId, ChangeSubjectIdeaDto dto) {
        MajorModuleSubject majorModuleSubject = fetchDataUtils.moduleSubjectById(moduleSubjectId);

        MajorModule majorModule = null;
        if(dto.getMajorModuleId() != null) majorModule = fetchDataUtils.majorModuleById(dto.getMajorModuleId());

        Tutor tutor = null;
        if(dto.getTutorId() != null) tutor = fetchDataUtils.tutorById(dto.getTutorId());

        Set<SubjectIdeaEffect> effects = new HashSet<>();
        if(!dto.getEffects().isEmpty() && dto.getEffects() != null) {
            dto.getEffects().forEach(effect -> {
                effects.add(createNewSingleEffect(effect));
            });
        }

        SubjectIdea result = ChangeSubjectIdeaDto.fromDto(dto, majorModuleSubject, majorModule, tutor, effects);
        result.setUser(userDetailsService.getLoggedUser());
        subjectIdeaRepository.save(result);
        return SubjectIdeaResponse.toResponse(result);
    }

    public SubjectIdeaResponse addNewSubjectIdea(NewSubjectIdeaDto dto) {
        MajorModule majorModule = fetchDataUtils.majorModuleById(dto.getMajorModuleId());
        Tutor tutor = fetchDataUtils.tutorById(dto.getTutorId());

        Set<SubjectIdeaEffect> effects = new HashSet<>();
        dto.getEffects().forEach(effect -> {
            effects.add(createNewSingleEffect(effect));
        });

        SubjectIdea result = NewSubjectIdeaDto.fromDto(dto, majorModule, tutor, effects);
        result.setUser(userDetailsService.getLoggedUser());
        subjectIdeaRepository.save(result);
        return SubjectIdeaResponse.toResponse(result);
    }

    public SubjectIdeaResponse addDeleteSubjectIdea(DeleteSubjectIdeaDto dto) {
        MajorModuleSubject majorModuleSubject = fetchDataUtils.moduleSubjectById(dto.getMajorModuleSubjectId());

        SubjectIdea result = DeleteSubjectIdeaDto.fromDto(dto, majorModuleSubject);
        result.setUser(userDetailsService.getLoggedUser());
        subjectIdeaRepository.save(result);
        return SubjectIdeaResponse.toResponse(result);
    }

    public void deleteSubjectIdea(Long subjectIdeaId) {
        subjectIdeaRepository.delete(fetchDataUtils.subjectIdeaById(subjectIdeaId));
    }

    private SubjectIdeaEffect createNewSingleEffect(SubjectEffectDto effect) {
        SubjectIdeaEffect singleEffect = new SubjectIdeaEffect();
        singleEffect.setEffect(fetchDataUtils.effectById(effect.getId()));
        singleEffect.setConnectionStrength(effect.getConnectionStrength());
        return singleEffect;
    }
}
