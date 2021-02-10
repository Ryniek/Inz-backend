package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.ModuleSubjectResponse;
import pl.rynski.inzynierkabackend.repository.ModuleSubjectRepository;

@Service
@RequiredArgsConstructor
public class ModuleSubjectService {

    private final ModuleSubjectRepository moduleSubjectRepository;

    public ModuleSubjectResponse addSubjectToModule(Long majorModuleId) {
        return null;
    }
}
