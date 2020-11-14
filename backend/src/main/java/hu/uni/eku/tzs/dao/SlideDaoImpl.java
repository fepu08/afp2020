package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class SlideDaoImpl implements SlideDao {
    private final SlideRepository repository;

    @Override
    public void create(Slide slide) {
        repository.save(SlideEntityModelConverter.model2entity(slide));
    }

    @Override
    public Collection<Slide> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> SlideEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Slide original, Slide updated) {

    }

    @Override
    public void delete(Slide slide) {

    }

    public static class SlideEntityModelConverter{
        public static Slide entity2model(hu.uni.eku.tzs.dao.entity.SlideEntity entity){
            return new Slide(
                    entity.getId(),
                    entity.getPrice(),
                    entity.getSlideCurrentTime()
            );
        }

        public static hu.uni.eku.tzs.dao.entity.SlideEntity model2entity(Slide model){
            return hu.uni.eku.tzs.dao.entity.SlideEntity.builder()
                    .id(model.getID())
                    .price(model.getPrice())
                    .slideCurrentTime(model.getSlideCurrentTime())
                    .build();
        }
    }
}
