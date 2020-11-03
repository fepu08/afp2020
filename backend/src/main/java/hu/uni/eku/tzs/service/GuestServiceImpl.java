package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.controller.dto.CheckOutGuestRequestDto;
import hu.uni.eku.tzs.controller.dto.GuestDto;
import hu.uni.eku.tzs.dao.ComplexNumberDao;
import hu.uni.eku.tzs.dao.GuestServiceDao;
import hu.uni.eku.tzs.model.ComplexNumber;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Watch;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class GuestServiceImpl implements GuestService {

    private final GuestServiceDao dao;

    @Override
    public void checkInGuest() {
        dao.create(new Guest());
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
    public void checkOutGuest(CheckOutGuestRequestDto request) {

    }
}
