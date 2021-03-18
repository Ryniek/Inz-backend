package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class MajorEffectSubjectId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long subjectId;
    private Long majorEffectId;

    public MajorEffectSubjectId() {
    }

    public MajorEffectSubjectId(Long subjectId, Long majorEffectId) {
        super();
        this.subjectId = subjectId;
        this.majorEffectId = majorEffectId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((subjectId == null) ? 0 : subjectId.hashCode());
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
        MajorEffectSubjectId other = (MajorEffectSubjectId) obj;
        return Objects.equals(getSubjectId(), other.getSubjectId()) && Objects.equals(getMajorEffectId(), other.getMajorEffectId());
    }
}
