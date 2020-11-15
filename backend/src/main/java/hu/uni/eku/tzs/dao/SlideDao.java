package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Slide;

import java.util.Collection;
import java.util.UUID;

public interface SlideDao {
    void create(Slide slide);

    Collection<Slide> readAll();


    Slide getSlideById(int id);

    void update(int originalSlideId, Slide updated);

    void delete(int slideId);
}
