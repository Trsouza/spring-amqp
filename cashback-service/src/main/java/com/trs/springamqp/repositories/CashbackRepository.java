package com.trs.springamqp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trs.springamqp.models.Cashback;


@Repository
public interface CashbackRepository extends MongoRepository<Cashback, String> {

}
