package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SubjectIdeaEffectId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long subjectIdeaId;
    private Long effectId;

    public SubjectIdeaEffectId() {
    }

    public SubjectIdeaEffectId(Long subjectIdeaId, Long effectId) {
        super();
        this.subjectIdeaId = subjectIdeaId;
        this.effectId = effectId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((subjectIdeaId == null) ? 0 : subjectIdeaId.hashCode());
        result = prime * result
                + ((effectId == null) ? 0 : effectId.hashCode());
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
        SubjectIdeaEffectId other = (SubjectIdeaEffectId) obj;
        return Objects.equals(getSubjectIdeaId(), other.getSubjectIdeaId()) && Objects.equals(getEffectId(), other.getEffectId());
    }
}
