package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.BillEntity;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<BillEntity, Integer> {
}
