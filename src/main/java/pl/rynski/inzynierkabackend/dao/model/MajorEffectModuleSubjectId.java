package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class MajorEffectModuleSubjectId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long majorModuleSubjectId;
    private Long majorEffectId;

    public MajorEffectModuleSubjectId() {
    }

    public MajorEffectModuleSubjectId(Long majorModuleSubjectId, Long majorEffectId) {
        super();
        this.majorModuleSubjectId = majorModuleSubjectId;
        this.majorEffectId = majorEffectId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((majorModuleSubjectId == null) ? 0 : majorModuleSubjectId.hashCode());
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
        MajorEffectModuleSubjectId other = (MajorEffectModuleSubjectId) obj;
        return Objects.equals(getMajorModuleSubjectId(), other.getMajorModuleSubjectId()) && Objects.equals(getMajorEffectId(), other.getMajorEffectId());
    }
}
