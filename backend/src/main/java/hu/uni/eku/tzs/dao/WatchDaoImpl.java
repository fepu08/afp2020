package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.WatchEntity;
import hu.uni.eku.tzs.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class WatchDaoImpl implements WatchDao {
    private final WatchRepository repository;

    @Override
    public void create(Watch watch) {
        WatchEntity entity = WatchEntityModelConverter.model2entity(watch);
        entity.setInUse(true);
        repository.save(entity);
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
    public void delete(UUID watchId) {
        hu.uni.eku.tzs.dao.entity.WatchEntity watchToDelete = repository.findWatchById(watchId);
        if(watchToDelete != null)
            repository.delete(watchToDelete);
    }

    @Override
    public void setWatchInactive(UUID watchId) {
        repository.setWatchInactiveById(watchId);
    }

    @Override
    public Watch findWatchByUserId(int id) {
        return WatchEntityModelConverter.entity2model(repository.findWatchByGuestId(id));
    }

    @Override
    public Watch findWatchById(UUID watchId) {
        return WatchEntityModelConverter.entity2model(repository.findWatchById(watchId));
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
