package hu.uni.eku.tzs.dao;


import hu.uni.eku.tzs.dao.entity.GuestEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<GuestEntity, Integer> {
    GuestEntity findGuestById(int Id);
}
