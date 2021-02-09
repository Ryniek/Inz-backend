package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.repository.MajorRepository;

@Service
@RequiredArgsConstructor
public class MajorService {
    private final MajorRepository majorRepository;


}
