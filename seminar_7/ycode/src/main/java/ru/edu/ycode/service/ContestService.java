package ru.edu.ycode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.ycode.exception.NotFoundException;
import ru.edu.ycode.model.entity.Contest;
import ru.edu.ycode.model.entity.Student;
import ru.edu.ycode.model.entity.Task;
import ru.edu.ycode.model.request.CreateContestRequest;
import ru.edu.ycode.repository.ContestRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContestService {

    private final ContestRepository contestRepository;
    private final StudentService studentService;
    private final TaskService taskService;


    public Iterable<Contest> findAll() {
        return contestRepository.findAll();
    }

    @Transactional
    public Contest createContest(CreateContestRequest createContestRequest) {
        List<Student> students = studentService.findByIdIn(createContestRequest.studentIds());
        if (students.size() != createContestRequest.studentIds().size()) {
            throw new NotFoundException(createContestRequest.studentIds(), StudentService.class);
        }
        List<Task> tasks = taskService.findByIdIn(createContestRequest.taskIds());
        if (tasks.size() != createContestRequest.taskIds().size()) {
            throw new NotFoundException(createContestRequest.studentIds(), TaskService.class);
        }
        var contest = new Contest();
        contest.setTasks(tasks);
        contest.setStudents(students);
        List<Student> studentsList = contest.getStudents();
        for (var s : studentsList) {
            System.out.println(s.getEmail()); // Exception
        }
        return contestRepository.save(contest);
    }

}
