package com.example.counterdemo2.controller;

import com.example.counterdemo2.entity.Counter;
import com.example.counterdemo2.service.CounterServiceImpl;
import com.example.counterdemo2.dao.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/counters")
public class CounterController {

    private CounterRepository CounterRepository;

    @Autowired
    private CounterServiceImpl counterService;

    // constructor
    public CounterController(CounterRepository counterRepository,
                             CounterServiceImpl counterService) {
        this.CounterRepository = counterRepository;
        this.counterService = counterService;
    }

    // methods for GUI

    @GetMapping("/list")
    public String listCounters(Model theModel) {

        // get the counters from db
        List<Counter> theCounters = counterService.findAll();

        // add to the spring model
        theModel.addAttribute("counters", theCounters);

        return "counters/list-counters";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Counter theCounter = new Counter();

        theModel.addAttribute("counter", theCounter);

        return "counters/counter-form";
    }

    @PostMapping("/save")
    public String saveCounter(@ModelAttribute("counter") Counter theCounter) {

        // save the counter
        counterService.save(theCounter);

        // use a redirect to prevent duplicate submissions
        return "redirect:/counters/list";
    }

    @GetMapping("/increase")
    public String increaseCounterById(@RequestParam("counterId") int theId, Model theModel) {
        counterService.increaseCounterById(theId);

        return "redirect:/counters/list";
    }

    @GetMapping("/decrease")
    public String decreaseCounterValue(@RequestParam("counterId") int theId, Model theModel) {

        counterService.decreaseCounterById(theId);

        return "redirect:/counters/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("counterId") int theId) {

        // delete the counter
        counterService.deleteById(theId);

        return "redirect:/counters/list";

    }

    // methods for simple CRUD
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
