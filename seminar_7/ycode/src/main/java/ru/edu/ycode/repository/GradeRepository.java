package ru.edu.ycode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.ycode.model.entity.Contest;
import ru.edu.ycode.model.entity.Grade;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    // select * from grades where contest_id in :contestIds
    List<Grade> findGradeByContestIn(List<Contest> contestIds);

}
