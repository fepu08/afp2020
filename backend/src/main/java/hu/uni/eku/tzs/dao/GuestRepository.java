package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.controller.dto.GuestDto;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<GuestDto, Integer> {
}
