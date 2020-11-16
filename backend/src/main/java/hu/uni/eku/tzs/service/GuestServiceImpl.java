package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.controller.dto.CheckOutGuestRequestDto;
import hu.uni.eku.tzs.dao.*;
import hu.uni.eku.tzs.model.*;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class GuestServiceImpl implements GuestService {

    private final GuestDao dao;
    private final WatchDao watchDao;
    private final TransactionDao transactionDao;
    private final SlideDao slideDao;
    private final UsageDao usageDao;

    @Override
    public void checkInGuest() {
        if(dao.IsFull()){
            log.info("Nincs több hely!");
        }
        else {
            dao.create(new Guest(), new Watch(), new Transaction());
        }
    }

    @Override
    public void recordUsage(Usage usage, Transaction transaction) {
        usageDao.create(usage, transaction);
    }

    @Override
    public Collection<Guest> getAllGuests() {
            return dao.readAll();
    }

    @Override
    public Collection<Usage> getUsagesByTransactionId(UUID id) {
        return usageDao.getUsagesByTransactionId(id);
    }

    @Override
    public Guest getGuestByID(int ID) throws GuestNotFoundByIDException {
        Collection<Guest> guests = getAllGuests();

        for (Guest guest: guests) {
            if(guest.getID() == ID){
                return guest;
            }
        }

        throw new GuestNotFoundByIDException();
    }

    @Override
    public Watch getWatchByGuestId(int id) {
        return watchDao.findWatchByUserId(id);
    }

    @Override
    public Transaction getTransactionByGuestId(int id) {
        return transactionDao.findTransactionByGuestId(id);
    }

    @Override
    public Slide getSlideById(int id) {
        return slideDao.readAll().stream().filter(slide -> slide.getID() == id).findFirst().orElse(null);
    }

    @Override
    public Slide getSlideByUsageId(int id) {
        return slideDao.getSlideByUsageId(id);
    }


    @Override
    public void checkOutGuest(CheckOutGuestRequestDto request) {
        watchDao.delete(request.getGuestID());
        transactionDao.delete(request.getGuestID());
        dao.delete(request.getGuestID());
    }

    @Override
    public Guest usedSlide(UUID watchId) {
        return dao.usedSlide(watchId);
    }
}
