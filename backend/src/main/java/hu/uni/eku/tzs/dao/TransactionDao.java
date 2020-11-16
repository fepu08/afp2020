package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.TransactionEntity;
import hu.uni.eku.tzs.model.*;

import java.util.Collection;

public interface TransactionDao {
    void create(Transaction transaction);

    Collection<Transaction> readAll();

    void update(Transaction original, Transaction updated);

    void delete(int guestId);

    Transaction findTransactionByGuestId(int id);
}
