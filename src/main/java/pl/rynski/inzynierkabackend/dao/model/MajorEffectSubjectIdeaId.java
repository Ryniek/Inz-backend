package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class MajorEffectSubjectIdeaId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long subjectIdeaId;
    private Long majorEffectId;

    public MajorEffectSubjectIdeaId() {
    }

    public MajorEffectSubjectIdeaId(Long subjectIdeaId, Long majorEffectId) {
        super();
        this.subjectIdeaId = subjectIdeaId;
        this.majorEffectId = majorEffectId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((subjectIdeaId == null) ? 0 : subjectIdeaId.hashCode());
        result = prime * result
                + ((majorEffectId == null) ? 0 : majorEffectId.hashCode());
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
        MajorEffectSubjectIdeaId other = (MajorEffectSubjectIdeaId) obj;
        return Objects.equals(getSubjectIdeaId(), other.getSubjectIdeaId()) && Objects.equals(getMajorEffectId(), other.getMajorEffectId());
    }
}
