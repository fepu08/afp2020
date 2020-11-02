package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GuestDto {
    private WatchDto watch;
    private int ID;
    private TransactionDto transactions;
    private LocalDateTime arrivalDateTime;
}
