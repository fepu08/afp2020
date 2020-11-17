package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.GuestDao;
import hu.uni.eku.tzs.dao.SlideDao;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.service.exceptions.SlideAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.SlideNotFoundByIdException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class SlideServiceImpl implements SlideService {
    private final SlideDao slideDao;
    private final GuestDao guestDao;

    @Override
    public void create(Slide slide) throws SlideAlreadyExistsException {
        final boolean alreadyCreated = slideDao.readAll()
                .stream()
                .anyMatch(s -> s.getPrice() == slide.getPrice() && s.getSlideName().toLowerCase().equals(slide.getSlideName().toLowerCase()));

        if (alreadyCreated){
            throw new SlideAlreadyExistsException(String.format("Ez a csúszda már létezik: %s", slide.toString()));
        }
        else slideDao.create(slide);
    }

    @Override
    public Collection<Slide> getAllSlides() {
        return slideDao.readAll();
    }

    @Override
    public Slide getSlideById(int id) throws SlideNotFoundByIdException {
        Slide slide = slideDao.readAll().stream().filter(s -> s.getID() == id).findFirst().orElse(null);
        if (slide == null)
            throw new SlideNotFoundByIdException(String.format("Nem létezik csúszda ezzel az ID-vel: %s", id));
        else return slide;
    }

    @Override
    public void update(int originalSlideId, Slide newSlide) throws SlideNotFoundByIdException{
        Slide slide = slideDao.getSlideById(originalSlideId);
        if (slide == null)
            throw new SlideNotFoundByIdException(String.format("Nem létezik csúszda ezzel az ID-vel: %s", originalSlideId));
        else slideDao.update(originalSlideId, newSlide);
    }

    @Override
    public void delete(int slideId) throws SlideNotFoundByIdException {
        Slide slide = slideDao.getSlideById(slideId);
        if (slide == null)
            throw new SlideNotFoundByIdException(String.format("Nem létezik csúszda ezzel az ID-vel: %s", slideId));
        else slideDao.delete(slideId);
    }

}
