package hu.uni.eku.tzs.dao;


import hu.uni.eku.tzs.dao.entity.GuestEntity;
import hu.uni.eku.tzs.dao.entity.TransactionEntity;
import hu.uni.eku.tzs.dao.entity.WatchEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<GuestEntity, Integer> {
    GuestEntity findGuestById(int id);
}
