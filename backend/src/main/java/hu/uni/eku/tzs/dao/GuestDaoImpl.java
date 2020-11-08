package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.GuestEntity;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class GuestDaoImpl implements GuestDao {

    private final GuestRepository repository;

    @Override
    public void create(Guest guest) {
    }

    @Override
    public Collection<Guest> readAll() {
        return null;
    }

    @Override
    public void update(Guest original, Guest updated) {

    }

    @Override
    public void delete(Guest guest) {

    }

}
