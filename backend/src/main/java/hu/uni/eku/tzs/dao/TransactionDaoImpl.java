package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class TransactionDaoImpl implements TransactionDao{
    private final TransactionRepository repository;

    @Override
    public void create(Transaction transaction) {

    }

    @Override
    public Collection<Transaction> readAll() {
        return null;
    }

    @Override
    public void update(Transaction original, Transaction updated) {

    }

    @Override
    public void delete(Transaction transaction) {

    }

    public static class TransactionEntityModelConverter{
        public static Transaction entity2model(hu.uni.eku.tzs.dao.entity.TransactionEntity entity){
            return new Transaction(
                    //entity.getId(),
            );
        }

        public static hu.uni.eku.tzs.dao.entity.TransactionEntity model2entity(Transaction model){
            return hu.uni.eku.tzs.dao.entity.TransactionEntity.builder()
                    //.id(model.getID())
                    .build();
        }
    }
}
