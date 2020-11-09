package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Watch;

import java.util.Collection;

public interface TransactionDao {
    void create(Transaction transaction);

    Collection<Transaction> readAll();

    void update(Transaction original, Transaction updated);

    void delete(Transaction transaction);
}
