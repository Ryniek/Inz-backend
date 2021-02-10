package pl.rynski.inzynierkabackend.dao.dto;

import lombok.Data;
import pl.rynski.inzynierkabackend.dao.model.Major;
import pl.rynski.inzynierkabackend.dao.model.MajorModule;
import pl.rynski.inzynierkabackend.dao.model.Module;
import pl.rynski.inzynierkabackend.dao.model.Tutor;

@Data
public class MajorModuleDto {
    private Long majorId;
    private Long moduleId;
    private Long tutorId;

    public static MajorModule fromDto(Major major, Module module, Tutor tutor) {
        MajorModule result = new MajorModule();
        result.setMajor(major);
        //major.addMajorModule(result);
        result.setModule(module);
        //module.addMajorModule(result);
        result.setTutor(tutor);
        //tutor.addMajorModule(result);
        return result;
    }
}
