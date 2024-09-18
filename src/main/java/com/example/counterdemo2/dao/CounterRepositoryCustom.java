package com.example.counterdemo2.dao;

import com.example.counterdemo2.entity.Counter;

public interface CounterRepositoryCustom {
    Counter findCounterByName(String counterName);
    Counter getCounterByName(String counterName);  // Custom GET operation
    Counter updateCounterByName(String counterName);  // Custom PUT operation
    void deleteCounterByName(String counterName);         // Custom DELETE operation
}
