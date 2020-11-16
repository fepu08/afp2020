package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.controller.dto.CheckOutGuestRequestDto;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import hu.uni.eku.tzs.model.*;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.UUID;

public interface GuestService {
    void checkInGuest();
    void recordUsage(Usage usage, Transaction transaction);
    Collection<Guest> getAllGuests();
    Collection<Usage> getUsagesByGuestId(int id);
    Guest getGuestByID(int ID) throws GuestNotFoundByIDException;
    Watch getWatchByGuestId(int id);
    Transaction getTransactionByGuestId(int id);
    Slide getSlideById(int id);
    Slide getSlideByUsageId(int id);
    void checkOutGuest(CheckOutGuestRequestDto request);
    Guest usedSlide(UUID watchId);
}
