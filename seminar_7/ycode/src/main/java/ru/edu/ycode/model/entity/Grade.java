package ru.edu.ycode.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.repository.Lock;

@Entity
@Getter
@Setter
@Table(name = "grade")
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Accessors(chain = true)
public class Grade {

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "contest_id", referencedColumnName = "id")
    private Contest contest;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Column(name = "value")
    private Long value;

}
