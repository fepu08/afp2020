package hu.uni.eku.tzs.model;

import hu.uni.eku.tzs.controller.dto.TransactionDto;
import hu.uni.eku.tzs.controller.dto.WatchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    private Watch watch;
    private int ID;
    private Transaction transactions;
    private LocalDateTime arrivalDateTime;
}
