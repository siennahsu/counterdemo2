package com.example.counterdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counters")
public class CounterController {

    private final com.example.counterdemo2.CounterRepository CounterRepository;

    @Autowired
    private CounterService counterService;

    public CounterController(CounterRepository counterRepository) {
        this.CounterRepository = counterRepository;
    }

    @GetMapping("/{name}")
    public Counter getCounterByName(@PathVariable String name) {
        return counterService.getCounterByName(name);
    }

    @PutMapping("/{name}")
    public Counter updateCounterByName(@PathVariable String name) {
        return counterService.updateCounterByName(name);
    }

    @DeleteMapping("/{name}")
    public void deleteCounterByName(@PathVariable String name) {
        counterService.deleteCounterByName(name);
    }
}
