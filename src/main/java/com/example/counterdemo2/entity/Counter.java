package com.example.counterdemo2.entity;

import jakarta.persistence.*;


@Entity
@Table(name="counter")
public class Counter {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="counter_name")
    private String counterName;

    @Column(name="value")
    private int value;

    // define constructors
    public Counter() { }

    public Counter(String counterName, int value) {
        this.counterName = counterName;
        this.value = value;
    }

    // define getter and setter
    public int getId() {
        return id;
    }

    public String getCounterName() {
        return counterName;
    }

    public int getValue() {
        return value;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // define toString

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", counterName='" + counterName + '\'' +
                ", value=" + value +
                '}';
    }
}
