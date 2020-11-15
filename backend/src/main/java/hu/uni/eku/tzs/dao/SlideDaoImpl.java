package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.SlideEntity;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
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
    public Slide getSlideById(int id) {
        return SlideEntityModelConverter.entity2model(repository.getSlideById(id));
    }

    @Override
    public void update(int originalSlideId, Slide updated) {
        hu.uni.eku.tzs.dao.entity.SlideEntity slideToUpdate = repository.getSlideById(originalSlideId);
        slideToUpdate.setPrice(updated.getPrice());
        repository.save(slideToUpdate);
    }

    @Override
    public void delete(int slideId) {
        hu.uni.eku.tzs.dao.entity.SlideEntity slideToDelete = repository.getSlideById(slideId);
        if(slideToDelete != null)
            repository.delete(slideToDelete);
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

    public static class SlideEntityCollectionModelConverter{
        public static Collection<hu.uni.eku.tzs.dao.entity.SlideEntity> collectionModel2collectionEntity(Collection<Slide> modelCollection){
            Collection<hu.uni.eku.tzs.dao.entity.SlideEntity> slideEntities = new ArrayList<SlideEntity>();
            for (Slide slide : modelCollection){
                slideEntities.add(SlideEntityModelConverter.model2entity(slide));
            }
            return slideEntities;
        }

        public static Collection<Slide> collectionEntity2collectionModel(Collection<hu.uni.eku.tzs.dao.entity.SlideEntity> entityCollection){
            Collection<Slide> slides = new ArrayList<>();
            for (SlideEntity slideEntity : entityCollection){
                slides.add(SlideEntityModelConverter.entity2model(slideEntity));
            }
            return slides;
        }
    }
}
