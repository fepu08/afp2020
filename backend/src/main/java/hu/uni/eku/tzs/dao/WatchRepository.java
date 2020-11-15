package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.WatchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WatchRepository extends CrudRepository<WatchEntity, Integer> {
    @Query(
        "SELECT w FROM WatchEntity w JOIN w.guest g WHERE g.id = ?1"
    )
    WatchEntity findWatchByGuestId(int id);
}
