package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.GuestDao;
import hu.uni.eku.tzs.dao.SlideDao;
import hu.uni.eku.tzs.model.Slide;
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
    public void create(Slide slide) {
        try {
            slideDao.create(slide);
        }
        catch (Exception ex)
        {
            log.info(ex.getMessage());
        }
    }

    @Override
    public Collection<Slide> getAllSlides() {
        return slideDao.readAll();
    }

    @Override
    public Slide getSlideById(int id) {
        return slideDao.readAll().stream().filter(slide -> slide.getID() == id).findFirst().orElse(null);
    }

    @Override
    public void update(int originalSlideId, Slide newSlide) {
        slideDao.update(originalSlideId, newSlide);
    }

    @Override
    public void delete(int slideId) {
        slideDao.delete(slideId);
    }

}
