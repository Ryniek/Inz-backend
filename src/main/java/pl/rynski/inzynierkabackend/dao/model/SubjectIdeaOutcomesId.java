package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SubjectIdeaOutcomesId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long subjectIdeaId;
    private Long educationalOutcomesId;

    public SubjectIdeaOutcomesId() {
    }

    public SubjectIdeaOutcomesId(Long subjectIdeaId, Long educationalOutcomesId) {
        super();
        this.subjectIdeaId = subjectIdeaId;
        this.educationalOutcomesId = educationalOutcomesId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((subjectIdeaId == null) ? 0 : subjectIdeaId.hashCode());
        result = prime * result
                + ((educationalOutcomesId == null) ? 0 : educationalOutcomesId.hashCode());
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
        SubjectIdeaOutcomesId other = (SubjectIdeaOutcomesId) obj;
        return Objects.equals(getSubjectIdeaId(), other.getSubjectIdeaId()) && Objects.equals(getEducationalOutcomesId(), other.getEducationalOutcomesId());
    }
}
