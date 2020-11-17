package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.service.exceptions.SlideAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.SlideNotFoundByIdException;

import java.util.Collection;


public interface SlideService {
    void create(Slide slide) throws SlideAlreadyExistsException;
    Collection<Slide> getAllSlides();
    Slide getSlideById(int id) throws SlideNotFoundByIdException;
    void update(int originalSlideId, Slide newSlide) throws SlideNotFoundByIdException;
    void delete(int slideId) throws SlideNotFoundByIdException;
}
