package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EffectIdeaSubjectId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long effectIdeaId;
    private Long subjectId;

    public EffectIdeaSubjectId() {
    }

    public EffectIdeaSubjectId(Long effectIdeaId, Long subjectId) {
        super();
        this.effectIdeaId = effectIdeaId;
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((effectIdeaId == null) ? 0 : effectIdeaId.hashCode());
        result = prime * result
                + ((subjectId == null) ? 0 : subjectId.hashCode());
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
        EffectIdeaSubjectId other = (EffectIdeaSubjectId) obj;
        return Objects.equals(getEffectIdeaId(), other.getEffectIdeaId()) && Objects.equals(getSubjectId(), other.getSubjectId());
    }
}
