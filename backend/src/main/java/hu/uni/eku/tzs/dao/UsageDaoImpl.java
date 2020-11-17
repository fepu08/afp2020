package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.UsageEntity;
import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Usage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsageDaoImpl implements UsageDao {
    private final UsageRepository repository;

    @Override
    public void create(Usage usage, Transaction transaction) {
        UsageEntity entity = UsageEntityModelConverter.model2entity(usage);
        entity.setTransaction(TransactionDaoImpl.TransactionEntityModelConverter.model2entity(transaction));
        repository.save(entity);
    }

    @Override
    public Collection<Usage> getUsagesByGuestId(int id) {
        return UsageEntityCollectionModelConverter.collectionEntity2collectionModel(repository.getUsagesByGuestId(id));
    }

    @Override
    public Collection<Usage> readAllUsage() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> UsageEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(int originalId, Usage newUsage) {

    }

    @Override
    public void delete(int id) {

    }

    public static class UsageEntityModelConverter{
        public static Usage entity2model(hu.uni.eku.tzs.dao.entity.UsageEntity entity){
            return new Usage(
                    entity.getId(),
                    entity.getGuestId(),
                    SlideDaoImpl.SlideEntityModelConverter.entity2model(entity.getSlide()),
                    entity.getTimestamp()
            );
        }

        public static hu.uni.eku.tzs.dao.entity.UsageEntity model2entity(Usage model){
            return hu.uni.eku.tzs.dao.entity.UsageEntity.builder()
                    .id(model.getId())
                    .guestId(model.getGuestId())
                    .slide(SlideDaoImpl.SlideEntityModelConverter.model2entity(model.getSlide()))
                    .timestamp(model.getTimestamp())
                    .build();
        }
    }

    public static class UsageEntityCollectionModelConverter{
        public static Collection<hu.uni.eku.tzs.dao.entity.UsageEntity> collectionModel2collectionEntity(Collection<Usage> modelCollection){
            Collection<hu.uni.eku.tzs.dao.entity.UsageEntity> usageEntities = new ArrayList<UsageEntity>();
            if(modelCollection == null)
                return usageEntities;
            else {
                for (Usage usage : modelCollection) {
                    usageEntities.add(UsageEntityModelConverter.model2entity(usage));
                }
            }
            return usageEntities;
        }

        public static Collection<Usage> collectionEntity2collectionModel(Collection<hu.uni.eku.tzs.dao.entity.UsageEntity> entityCollection){
            Collection<Usage> usages = new ArrayList<>();
            for (UsageEntity usageEntity : entityCollection){
                usages.add(UsageEntityModelConverter.entity2model(usageEntity));
            }
            return usages;
        }
    }
}
