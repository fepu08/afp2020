package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.GuestEntity;
import hu.uni.eku.tzs.dao.entity.TransactionEntity;
import hu.uni.eku.tzs.dao.entity.WatchEntity;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Watch;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class GuestDaoImpl implements GuestDao {

    private final GuestRepository repository;

    @Override
    public void create(Guest guest, Watch watch, Transaction transaction) {
        GuestEntity entity = GuestEntityModelConverter.model2entity(guest);
        entity.setWatch(WatchDaoImpl.WatchEntityModelConverter.model2entity(watch));
        entity.setTransaction(TransactionDaoImpl.TransactionEntityModelConverter.model2entity(transaction));
        //entity.setArrivalDateTime();
        repository.save(entity);
    }

    @Override
    public Collection<Guest> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(guestEntity -> GuestEntityModelConverter.entity2model(guestEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(int guestId, Guest updated) {

    }

    @Override
    public void delete(int guestId) {
        hu.uni.eku.tzs.dao.entity.GuestEntity guestToDelete = repository.findGuestById(guestId);
        if(guestToDelete != null)
            repository.delete(guestToDelete);
    }

    @Override
    public Guest findGuestById(int id) {
        return GuestEntityModelConverter.entity2model(repository.findGuestById(id));
    }

    @Override
    public Guest usedSlide(UUID watchId) {
        return GuestEntityModelConverter.entity2model(repository.findGuestByWatchId(watchId));
    }

    @Override
    public boolean IsFull() {
        return repository.numberOfCheckedInGuests() == 3;
    }

    @Override
    public long checkedInGuests() {
        return repository.numberOfCheckedInGuests();
    }


    public static class GuestEntityModelConverter{
        public static Guest entity2model(hu.uni.eku.tzs.dao.entity.GuestEntity entity){
            return new Guest(
                    entity.getId(),
                    entity.getArrivalDateTime()
            );
        }

        public static hu.uni.eku.tzs.dao.entity.GuestEntity model2entity(Guest model){
            return hu.uni.eku.tzs.dao.entity.GuestEntity.builder()
                    .id(model.getID())
                    .arrivalDateTime(model.getArrivalDateTime())
                    .build();
        }
    }

}
