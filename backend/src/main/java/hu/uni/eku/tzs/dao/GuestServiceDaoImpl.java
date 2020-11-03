package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class GuestServiceDaoImpl implements GuestServiceDao {

    private final GuestRepository repository;

    @Override
    public void create(Guest guestDto) {
    }

    @Override
    public Collection<Guest> readAll() {
        return null;
    }

    @Override
    public void update(Guest original, Guest updated) {

    }

    @Override
    public void delete(Guest guestDto) {

    }
}
