package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.SlideEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.UUID;

public interface SlideRepository extends CrudRepository<SlideEntity, Integer> {
    SlideEntity getSlideById(int id);

    @Query(
            "SELECT slide FROM SlideEntity slide WHERE slide.transaction.id=?1"
    )
    Collection<SlideEntity> getSlidesByTransactionId(UUID transactionId);
}
