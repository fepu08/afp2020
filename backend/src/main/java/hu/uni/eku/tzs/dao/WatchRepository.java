package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.WatchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface WatchRepository extends CrudRepository<WatchEntity, Integer> {
    @Query(
        "SELECT w FROM WatchEntity w JOIN w.guest g WHERE g.id = ?1"
    )
    WatchEntity findWatchByGuestId(int id);
    WatchEntity findWatchById(UUID watchId);

    @Query(
            "UPDATE WatchEntity w SET w.inUse=FALSE WHERE w.id=?1"
    )
    void setWatchInactiveById(UUID watchId);
}
