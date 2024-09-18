package com.example.counterdemo2.dao;

import com.example.counterdemo2.entity.Counter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class CounterRepositoryCustomImpl implements CounterRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Counter findCounterByName(String counterName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Counter> criteriaQuery = criteriaBuilder.createQuery(Counter.class);
        Root<Counter> counterRoot = criteriaQuery.from(Counter.class);
        criteriaQuery.select(counterRoot)
                .where(criteriaBuilder.equal(counterRoot.get("counterName"), counterName));

        return entityManager.createQuery(criteriaQuery).getResultStream().findFirst().orElse(null);
    }

    @Override
    public Counter getCounterByName(String counterName) {
        Counter counter = findCounterByName(counterName);
        if (counter != null) { return counter; }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Counter not found");
        }
    }

    @Override
    @Transactional
    public Counter updateCounterByName(String counterName) {
        Counter counter = findCounterByName(counterName);
        if (counter != null) {
            counter.setValue(counter.getValue()+1);
            entityManager.merge(counter);
            return counter;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Counter not found");
        }
    }

    @Override
    @Transactional
    public void deleteCounterByName(String counterName) {
        Counter counter = findCounterByName(counterName);
        if (counter != null) {
            int newCounterValue = counter.getValue() - 1;
            if (newCounterValue <= 0) { entityManager.remove(counter); }
            else {
                counter.setValue(newCounterValue);
                entityManager.merge(counter);
            }
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Counter not found");
        }
    }
}
