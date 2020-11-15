package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.controller.dto.CheckOutGuestRequestDto;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Watch;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.UUID;

public interface GuestService {
    void checkInGuest();
    Collection<Guest> getAllGuests();
    Guest getGuestByID(int ID) throws GuestNotFoundByIDException;
    Watch getWatchByGuestId(int id);
    Transaction getTransactionByGuestId(int id);
    Slide getSlideById(int id);
    void checkOutGuest(CheckOutGuestRequestDto request);
    Guest usedSlide(UUID watchId);
}
