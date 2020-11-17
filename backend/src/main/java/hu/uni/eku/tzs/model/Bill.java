package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    private int id;
    private UUID watchID;
    private UUID transactionID;
    private int finalPrice;
    private LocalDate date;
}
