package ru.edu.ycode.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "student")
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Accessors(chain = true)
public class Student {

    @Id
    private Long id;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
        name = "student_to_contest",
        joinColumns = {@JoinColumn(name = "student_id")},
        inverseJoinColumns = {@JoinColumn(name = "contest_id")} // create table(student_id long, contest_id long);
    )
    // select s.* from student s join student_to_contest st on s.id = st.student_id join contest c on c.id = st.contest_id;
    private Set<Contest> contests;

    @OneToMany(mappedBy = "student")
    private Set<Attempt> attempts;

}
