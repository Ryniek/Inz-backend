package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.TutorDto;
import pl.rynski.inzynierkabackend.dao.dto.response.TutorResponse;
import pl.rynski.inzynierkabackend.dao.model.Tutor;
import pl.rynski.inzynierkabackend.repository.TutorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public List<TutorResponse> getTutors() {
        return tutorRepository.findAll().stream()
                .map(TutorResponse::toResponse)
                .collect(Collectors.toList());
    }

    public TutorResponse addTutor(TutorDto tutorDto) {
        Tutor tutor = TutorDto.fromDto(tutorDto);
        return TutorResponse.toResponse(tutorRepository.save(tutor));
    }
}
