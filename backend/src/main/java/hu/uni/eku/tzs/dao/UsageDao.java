package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Usage;

import java.util.Collection;
import java.util.UUID;

public interface UsageDao {
    void create(Usage usage, Transaction transaction);

    Collection<Usage> getUsagesByTransactionId(UUID id);

    Collection<Usage> readAllUsage();

    void update(int originalId, Usage newUsage);

    void delete(int id);
}
