package pl.rynski.inzynierkabackend.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ContactHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lecture", columnDefinition = "INTEGER default 0")
    private Integer lecture;

    @Column(name = "exercise", columnDefinition = "INTEGER default 0")
    private Integer exercise;

    @Column(name = "laboratory", columnDefinition = "INTEGER default 0")
    private Integer laboratory;

    @Column(name = "seminar", columnDefinition = "INTEGER default 0")
    private Integer seminar;

    @Column(name = "project", columnDefinition = "INTEGER default 0")
    private Integer project;

    @OneToOne(mappedBy = "contactHours", fetch = FetchType.LAZY)
    private FieldModuleSubject fieldModuleSubject;

    @OneToOne(mappedBy = "contactHours", fetch = FetchType.LAZY)
    private SubjectIdea subjectIdea;
}
