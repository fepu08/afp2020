package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.controller.dto.CheckOutGuestRequestDto;
import hu.uni.eku.tzs.dao.GuestDao;
import hu.uni.eku.tzs.dao.TransactionDao;
import hu.uni.eku.tzs.dao.WatchDao;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Transaction;
import hu.uni.eku.tzs.model.Watch;
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

    @Override
    public void checkInGuest() {
        dao.create(new Guest(), new Watch(), new Transaction());
    }

    @Override
    public Collection<Guest> getAllGuests() {
            return dao.readAll();
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
    public void checkOutGuest(CheckOutGuestRequestDto request) {

    }
}
