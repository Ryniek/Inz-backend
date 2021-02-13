package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SubjectEffectIdeaId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long majorModuleSubjectId;
    private Long effectIdeaId;

    public SubjectEffectIdeaId() {
    }

    public SubjectEffectIdeaId(Long majorModuleSubjectId, Long effectIdeaId) {
        super();
        this.majorModuleSubjectId = majorModuleSubjectId;
        this.effectIdeaId = effectIdeaId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((majorModuleSubjectId == null) ? 0 : majorModuleSubjectId.hashCode());
        result = prime * result
                + ((effectIdeaId == null) ? 0 : effectIdeaId.hashCode());
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
        SubjectEffectIdeaId other = (SubjectEffectIdeaId) obj;
        return Objects.equals(getMajorModuleSubjectId(), other.getMajorModuleSubjectId()) && Objects.equals(getEffectIdeaId(), other.getEffectIdeaId());
    }
}
