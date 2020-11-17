package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.BillItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface BillItemRepository extends CrudRepository<BillItemEntity, Integer> {
}
