package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class WatchDaoImpl implements WatchDao {
    private final WatchRepository repository;

    @Override
    public void create(Watch watch) {
        repository.save(WatchEntityModelConverter.model2entity(watch));
    }

    @Override
    public Collection<Watch> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> WatchEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Watch original, Watch updated) {

    }

    @Override
    public void delete(Watch watch) {
        
    }

    @Override
    public Watch findWatchByUserId(int id) {
        return WatchEntityModelConverter.entity2model(repository.findWatchByGuestId(id));
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
