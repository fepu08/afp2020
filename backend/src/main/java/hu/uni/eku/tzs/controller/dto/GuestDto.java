package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class GuestDto {
    private WatchDto watch;
    private int ID;
    private TransactionDto transactions;
    private LocalDateTime arrivalDateTime;
}
