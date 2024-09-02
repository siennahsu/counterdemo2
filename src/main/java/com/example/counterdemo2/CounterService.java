package com.example.counterdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    @Autowired
    private CounterRepository counterRepository;

    public Counter getCounterByName(String name) {
        return counterRepository.getCounterByName(name);
    }

    public Counter updateCounterByName(String name) {
        return counterRepository.updateCounterByName(name);
    }

    public void deleteCounterByName(String name) {
        counterRepository.deleteCounterByName(name);
    }
}
