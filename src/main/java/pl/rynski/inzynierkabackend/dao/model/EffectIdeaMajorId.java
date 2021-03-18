package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EffectIdeaMajorId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long effectIdeaId;
    private Long majorId;

    public EffectIdeaMajorId() {
    }

    public EffectIdeaMajorId(Long effectIdeaId, Long majorId) {
        super();
        this.effectIdeaId = effectIdeaId;
        this.majorId = majorId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((effectIdeaId == null) ? 0 : effectIdeaId.hashCode());
        result = prime * result
                + ((majorId == null) ? 0 : majorId.hashCode());
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
        EffectIdeaMajorId other = (EffectIdeaMajorId) obj;
        return Objects.equals(getEffectIdeaId(), other.getEffectIdeaId()) && Objects.equals(getMajorId(), other.getMajorId());
    }
}
