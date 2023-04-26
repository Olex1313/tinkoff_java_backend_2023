package ru.edu.ycode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.ycode.model.entity.Contest;
import ru.edu.ycode.model.request.CreateContestRequest;
import ru.edu.ycode.service.ContestService;

@RestController
@RequestMapping("/contest")
@RequiredArgsConstructor
public class ContestController {

    private final ContestService contestService;

    @GetMapping
    public Iterable<Contest> findAll() {
        return contestService.findAll();
    }


    public Contest createContest(@RequestBody CreateContestRequest createContestRequest) {
        return contestService.createContest(createContestRequest);
    }

}
