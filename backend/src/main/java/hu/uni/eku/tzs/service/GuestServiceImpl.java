package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.*;
import hu.uni.eku.tzs.model.*;
import hu.uni.eku.tzs.service.exceptions.AquaparkFullException;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import hu.uni.eku.tzs.service.exceptions.SlideNotFoundByIdException;
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
    public void checkInGuest() throws AquaparkFullException {
        if(dao.IsFull()){
            throw new AquaparkFullException("Nincs több hely az aquaparkban!");
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
    public Collection<Usage> getUsagesByGuestId(int id) {
        return usageDao.getUsagesByGuestId(id);
    }

    @Override
    public Guest getGuestByID(int ID) throws GuestNotFoundByIDException {
        Guest guest = getAllGuests().stream().filter(g -> g.getID() == ID).findFirst().orElse(null);
        if (guest == null)
            throw new GuestNotFoundByIDException(String.format("Nem létezik vendég ezzel az ID-vel: %s", ID));
        else return guest;
    }

    @Override
    public Watch getWatchByGuestId(int id){
        return watchDao.findWatchByUserId(id);
    }

    @Override
    public Transaction getTransactionByGuestId(int id) {
        return transactionDao.findTransactionByGuestId(id);
    }

    @Override
    public Slide getSlideById(int id) throws SlideNotFoundByIdException{
        Slide slide = slideDao.readAll().stream().filter(s -> s.getID() == id).findFirst().orElse(null);
        if (slide == null)
            throw new SlideNotFoundByIdException("Ez a csúszda nem létezik!");
        else return slide;
    }

    @Override
    public Slide getSlideByUsageId(int id) {
            return slideDao.getSlideByUsageId(id);
    }

    @Override
    public void checkOutGuest(int id) throws GuestNotFoundByIDException {
        Guest guest = dao.readAll().stream().filter(g -> g.getID() == id).findFirst().orElse(null);
        if(guest == null)
            throw new GuestNotFoundByIDException(String.format("Nem létezik vendég ilyen ID-vel: %s",id));
        else dao.delete(id);
    }

    @Override
    public Guest usedSlide(UUID watchId) {
        return dao.usedSlide(watchId);
    }
}
