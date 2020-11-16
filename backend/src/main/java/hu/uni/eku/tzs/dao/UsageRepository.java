package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.UsageEntity;
import hu.uni.eku.tzs.model.Usage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.UUID;

public interface UsageRepository extends CrudRepository<UsageEntity, Integer> {
    @Query(
            "SELECT u FROM UsageEntity u JOIN u.transaction t WHERE t.id=?1"
    )
    Collection<UsageEntity> getUsagesByTransactionId(UUID id);
}
