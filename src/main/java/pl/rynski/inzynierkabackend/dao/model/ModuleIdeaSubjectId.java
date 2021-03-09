package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ModuleIdeaSubjectId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long moduleIdeaId;
    private Long subjectId;
    private Long tutorId;

    public ModuleIdeaSubjectId() {
    }

    public ModuleIdeaSubjectId(Long moduleIdeaId, Long subjectId, Long tutorId) {
        super();
        this.moduleIdeaId = moduleIdeaId;
        this.subjectId = subjectId;
        this.tutorId = tutorId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((moduleIdeaId == null) ? 0 : moduleIdeaId.hashCode());
        result = prime * result
                + ((subjectId == null) ? 0 : subjectId.hashCode());
        result = prime * result
                + (((tutorId == null)) ? 0 : tutorId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModuleIdeaSubjectId other = (ModuleIdeaSubjectId) obj;
        return Objects.equals(getSubjectId(), other.getSubjectId()) && Objects.equals(getModuleIdeaId(), other.getModuleIdeaId())&& Objects.equals(getTutorId(), other.getTutorId());
    }
}
