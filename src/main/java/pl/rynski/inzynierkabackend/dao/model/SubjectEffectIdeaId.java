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
    private Long subjectId;
    private Long effectIdeaId;

    public SubjectEffectIdeaId() {
    }

    public SubjectEffectIdeaId(Long subjectId, Long effectIdeaId) {
        super();
        this.subjectId = subjectId;
        this.effectIdeaId = effectIdeaId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((subjectId == null) ? 0 : subjectId.hashCode());
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
        return Objects.equals(getSubjectId(), other.getSubjectId()) && Objects.equals(getEffectIdeaId(), other.getEffectIdeaId());
    }
}
