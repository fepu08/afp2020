package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Slide;

import java.util.Collection;

public interface SlideDao {
    void create(Slide slide);

    Collection<Slide> readAll();

    void update(Slide original, Slide updated);

    void delete(Slide slide);
}
