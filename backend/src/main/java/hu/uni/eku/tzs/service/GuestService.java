package hu.uni.eku.tzs.service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import hu.uni.eku.tzs.controller.dto.CheckOutGuestRequestDto;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import hu.uni.eku.tzs.model.*;
import hu.uni.eku.tzs.service.exceptions.AquaparkFullException;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import hu.uni.eku.tzs.service.exceptions.SlideNotFoundByIdException;
import hu.uni.eku.tzs.service.exceptions.WatchNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.UUID;

public interface GuestService {
    void checkInGuest() throws AquaparkFullException;
    void recordUsage(Usage usage, Transaction transaction);
    void checkOutGuest(int id) throws GuestNotFoundByIDException;
    Collection<Guest> getAllGuests();
    Collection<Usage> getUsagesByGuestId(int id);
    Guest getGuestByID(int ID) throws GuestNotFoundByIDException;
    Watch getWatchByGuestId(int id);
    Transaction getTransactionByGuestId(int id);
    Slide getSlideById(int id) throws SlideNotFoundByIdException;
    Slide getSlideByUsageId(int id);
    Guest usedSlide(UUID watchId);
}
