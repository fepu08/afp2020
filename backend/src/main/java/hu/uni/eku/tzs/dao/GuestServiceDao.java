package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guest;

import java.util.Collection;

public interface GuestServiceDao {

    void create(Guest guestDto);

    Collection<Guest> readAll();

    void update(Guest original, Guest updated);

    void delete(Guest guestDto);
}
