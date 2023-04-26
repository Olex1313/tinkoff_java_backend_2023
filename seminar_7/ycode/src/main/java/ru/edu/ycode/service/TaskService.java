package ru.edu.ycode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.ycode.model.entity.Task;
import ru.edu.ycode.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findByIdIn(List<Long> ids) {
        return taskRepository.findAllById(ids);
    }

}
