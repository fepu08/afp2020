package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Watch;

import java.util.Collection;
import java.util.UUID;

public interface WatchDao {
    void create(Watch watch);

    Collection<Watch> readAll();

    void update(Watch original, Watch updated);

    void delete(UUID watchId);

    void setWatchInactive(UUID watchId);

    Watch findWatchByUserId(int id);

    Watch findWatchById(UUID watchId);
}
