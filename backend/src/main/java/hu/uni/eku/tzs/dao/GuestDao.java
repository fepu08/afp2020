package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Watch;

import java.util.Collection;

public interface GuestDao {

    void create(Guest guest, Watch watch, Transaction transaction);

    Collection<Guest> readAll();

    void update(Guest original, Guest updated);

    void delete(Guest guest);
}
