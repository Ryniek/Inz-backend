package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EffectIdeaModuleSubjectId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long effectIdeaId;
    private Long majorModuleSubjectId;

    public EffectIdeaModuleSubjectId() {
    }

    public EffectIdeaModuleSubjectId(Long effectIdeaId, Long majorModuleSubjectId) {
        super();
        this.effectIdeaId = effectIdeaId;
        this.majorModuleSubjectId = majorModuleSubjectId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((effectIdeaId == null) ? 0 : effectIdeaId.hashCode());
        result = prime * result
                + ((majorModuleSubjectId == null) ? 0 : majorModuleSubjectId.hashCode());
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
        EffectIdeaModuleSubjectId other = (EffectIdeaModuleSubjectId) obj;
        return Objects.equals(getEffectIdeaId(), other.getEffectIdeaId()) && Objects.equals(getMajorModuleSubjectId(), other.getMajorModuleSubjectId());
    }
}
