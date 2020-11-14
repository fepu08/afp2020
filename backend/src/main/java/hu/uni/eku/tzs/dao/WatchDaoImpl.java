package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class WatchDaoImpl implements WatchDao {
    private final WatchRepository repository;

    @Override
    public void create() {

    }

    @Override
    public Collection<Watch> readAll() {
        return null;
    }

    @Override
    public void update(Watch original, Watch updated) {

    }

    @Override
    public void delete(Watch watch) {

    }

    public static class WatchEntityModelConverter{
        public static Watch entity2model(hu.uni.eku.tzs.dao.entity.WatchEntity entity){
            return new Watch(
                    entity.getId(),
                    entity.getInUse()
            );
        }

        public static hu.uni.eku.tzs.dao.entity.WatchEntity model2entity(Watch model){
            return hu.uni.eku.tzs.dao.entity.WatchEntity.builder()
                    .id(model.getWatchID())
                    .inUse(model.getInUse())
                    .build();
        }
    }
}