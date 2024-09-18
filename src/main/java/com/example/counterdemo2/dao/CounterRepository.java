package com.example.counterdemo2.dao;

import com.example.counterdemo2.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterRepository extends JpaRepository<Counter, String>, CounterRepositoryCustom {

    public List<Counter> findAllByOrderByCounterNameAsc();

}
