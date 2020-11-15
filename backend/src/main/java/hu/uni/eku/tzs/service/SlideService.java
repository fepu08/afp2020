package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Slide;

import java.util.Collection;


public interface SlideService {
    void create(Slide slide);
    Collection<Slide> getAllSlides();
    Slide getSlideById(int id);
    void update(int originalSlideId, Slide newSlide);
    void delete(int slideId);
}
