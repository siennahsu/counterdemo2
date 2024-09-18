package com.example.counterdemo2.service;

import com.example.counterdemo2.dao.CounterRepository;
import com.example.counterdemo2.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CounterServiceImpl implements CounterService{

    private CounterRepository counterRepository;

    @Autowired
    public CounterServiceImpl(CounterRepository theCounterRepository) {
        counterRepository = theCounterRepository;
    }


    @Override
    public List<Counter> findAll() {
        return counterRepository.findAllByOrderByCounterNameAsc();
    }

    @Override
    public Counter findById(int theId) {
        Optional<Counter> result = counterRepository.findById(String.valueOf(theId));

        Counter theCounter = null;

        if (result.isPresent()) {
            theCounter = result.get();
        }
        else {
            // we didn't find the counter
            throw new RuntimeException("Did not find counter id - " + theId);
        }

        return theCounter;
    }

    @Override
    public void save(Counter theCounter) {
        counterRepository.save(theCounter);
    }

    @Override
    public void deleteById(int theId) {
        counterRepository.deleteById(String.valueOf(theId));
    }

    @Override
    public void increaseCounterById(int id) {

        // retrieve the counter
        Counter theCounter = findById(id);

        // increase the value by 1
        theCounter.setValue(theCounter.getValue()+1);

        // save the counter
        save(theCounter);
    }

    @Override
    public void decreaseCounterById(int id) {

        // retrieve the counter
        Counter theCounter = findById(id);

        // decrease the value by 1
        int newValue = theCounter.getValue() - 1;

        // if counter value <= 0, delete the counter
        if (newValue <= 0) { deleteById(id); }
        else {
            theCounter.setValue(newValue);
            save(theCounter); }

    }

    @Override
    public Counter getCounterByName(String name) {
        return counterRepository.getCounterByName(name);
    }

    @Override
    public Counter updateCounterByName(String name) {
        return counterRepository.updateCounterByName(name);
    }

    @Override
    public void deleteCounterByName(String name) {
        counterRepository.deleteCounterByName(name);
    }

}
