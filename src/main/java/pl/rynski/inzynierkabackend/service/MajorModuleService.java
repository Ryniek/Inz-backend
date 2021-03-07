package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.MajorModuleDto;
import pl.rynski.inzynierkabackend.dao.dto.response.MajorModuleResponse;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.dao.model.Tutor;
import pl.rynski.inzynierkabackend.repository.MajorModuleRepository;
import pl.rynski.inzynierkabackend.utils.FetchDataUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorModuleService {

    private final MajorModuleRepository majorModuleRepository;
    private final FetchDataUtils fetchDataUtils;

    public List<MajorModuleResponse> getModulesByMajor(Long majorId) {
        Major major = fetchDataUtils.majorById(majorId);

        return majorModuleRepository.findAllByMajor(major).stream()
                .map(MajorModuleResponse::toResponse)
                .collect(Collectors.toList());
    }

    public MajorModuleResponse assingModuleToMajor(MajorModuleDto majorModuleDto) {
        //TODO sprawdzic czy modul o takim id nie jest juz przypisany, jesli jest to zwrocic jakas odpowiedz
        Major major = fetchDataUtils.majorById(majorModuleDto.getMajorId());
        Module module = fetchDataUtils.moduleById(majorModuleDto.getModuleId());
        Tutor tutor = fetchDataUtils.tutorById(majorModuleDto.getTutorId());

        MajorModule result = majorModuleRepository.save(MajorModuleDto.fromDto(major, module, tutor));
        return MajorModuleResponse.toResponse(result);
    }

    public void deleteMajorModule(Long majorModuleId) {
        majorModuleRepository.delete(fetchDataUtils.majorModuleById(majorModuleId));
    }
}
