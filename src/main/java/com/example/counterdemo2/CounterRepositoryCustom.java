package com.example.counterdemo2;

public interface CounterRepositoryCustom {
    public Counter findCounterByName(String counterName);
    Counter getCounterByName(String counterName);  // Custom GET operation
    Counter updateCounterByName(String counterName);  // Custom PUT operation
    void deleteCounterByName(String counterName);         // Custom DELETE operation
}
