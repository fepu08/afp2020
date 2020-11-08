package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {

}
