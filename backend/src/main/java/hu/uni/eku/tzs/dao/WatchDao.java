package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Watch;

import java.util.Collection;

public interface WatchDao {
    void create(Watch watch);

    Collection<Watch> readAll();

    void update(Watch original, Watch updated);

    void delete(Watch watch);

    Watch findWatchByUserId(int id);
}
