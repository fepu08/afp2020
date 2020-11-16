package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.TransactionEntity;
import hu.uni.eku.tzs.dao.entity.WatchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
    @Query(
            "SELECT t FROM TransactionEntity t JOIN t.guest g WHERE g.id = ?1"
    )
    TransactionEntity findTransactionByGuestId(int id);
    TransactionEntity findTransactionById(UUID transactionId);
}
