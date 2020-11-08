package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guest;

import java.util.Collection;

public interface GuestDao {

    void create(Guest guest);

    Collection<Guest> readAll();

    void update(Guest original, Guest updated);

    void delete(Guest guest);
}
