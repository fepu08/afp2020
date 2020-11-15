package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Watch;

import java.util.Collection;
import java.util.UUID;

public interface GuestDao {

    void create(Guest guest, Watch watch, Transaction transaction);

    Collection<Guest> readAll();

    void update(int guestId, Guest updated);

    void delete(int guestId);

    Guest findGuestById(int id);

    Guest usedSlide(UUID watchId);

    boolean IsFull();

    long checkedInGuests();
}
