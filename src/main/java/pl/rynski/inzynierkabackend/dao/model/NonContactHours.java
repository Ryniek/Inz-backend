package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class NonContactHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consultation", columnDefinition = "INTEGER default 0")
    private Integer consultation;

    @Column(name = "exam", columnDefinition = "INTEGER default 0")
    private Integer exam;

    @Column(name = "pwt", columnDefinition = "INTEGER default 0")
    private Integer pwt;

    @Column(name = "pwp", columnDefinition = "INTEGER default 0")
    private Integer pwp;

    @OneToOne(mappedBy = "nonContactHours", fetch = FetchType.LAZY)
    private MajorModuleSubject majorModuleSubject;

    @OneToOne(mappedBy = "nonContactHours", fetch = FetchType.LAZY)
    private SubjectIdea subjectIdea;
}
