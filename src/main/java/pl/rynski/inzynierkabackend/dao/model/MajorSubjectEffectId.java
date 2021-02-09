package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class MajorSubjectEffectId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long majorModuleSubjectId;
    private Long effectId;

    public MajorSubjectEffectId() {
    }

    public MajorSubjectEffectId(Long majorModuleSubjectId, Long effectId) {
        super();
        this.majorModuleSubjectId = majorModuleSubjectId;
        this.effectId = effectId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((majorModuleSubjectId == null) ? 0 : majorModuleSubjectId.hashCode());
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
        MajorSubjectEffectId other = (MajorSubjectEffectId) obj;
        return Objects.equals(getMajorModuleSubjectId(), other.getMajorModuleSubjectId()) && Objects.equals(getEffectId(), other.getEffectId());
    }
}
