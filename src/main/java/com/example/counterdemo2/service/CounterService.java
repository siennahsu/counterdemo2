package com.example.counterdemo2.service;

import com.example.counterdemo2.entity.Counter;

import java.util.List;

public interface CounterService {

    List<Counter> findAll();

    Counter findById(int Id);

    void save(Counter theEmployee);

    void deleteById(int theId);

    void increaseCounterById(int id);

    void decreaseCounterById(int id);

    public Counter getCounterByName(String name);

    public Counter updateCounterByName(String name);

    public void deleteCounterByName(String name);
}
