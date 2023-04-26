package ru.edu.ycode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.ycode.model.entity.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Long> {

}
