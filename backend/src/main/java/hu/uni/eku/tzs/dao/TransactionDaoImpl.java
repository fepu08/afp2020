package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.SlideEntity;
import hu.uni.eku.tzs.dao.entity.TransactionEntity;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class TransactionDaoImpl implements TransactionDao{
    private final TransactionRepository repository;

    @Override
    public void create(Transaction transaction, Collection<Slide> slips) {
        TransactionEntity entity = TransactionEntityModelConverter.model2entity(transaction);
        entity.setSlips(SlideDaoImpl.SlideEntityCollectionModelConverter.collectionModel2collectionEntity(slips));
        repository.save(entity);
    }

    @Override
    public Collection<Transaction> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> TransactionEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Transaction original, Transaction updated) {

    }

    @Override
    public void delete(int guestId) {
        hu.uni.eku.tzs.dao.entity.TransactionEntity transactionToDelete = repository.findTransactionByGuestId(guestId);
        if(transactionToDelete != null)
            repository.delete(transactionToDelete);
    }

    @Override
    public Transaction findTransactionByGuestId(int id) {
        return TransactionEntityModelConverter.entity2model(repository.findTransactionByGuestId(id));
    }

    public static class TransactionEntityModelConverter{
        public static Transaction entity2model(hu.uni.eku.tzs.dao.entity.TransactionEntity entity){
            return new Transaction(
                    entity.getId(),
                    SlideDaoImpl.SlideEntityCollectionModelConverter.collectionEntity2collectionModel(entity.getSlips())
            );
        }

        public static hu.uni.eku.tzs.dao.entity.TransactionEntity model2entity(Transaction model){
            return hu.uni.eku.tzs.dao.entity.TransactionEntity.builder()
                    .id(model.getID())
                    .build();
        }
    }
}
