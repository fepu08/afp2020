package hu.uni.eku.tzs.controller.dto;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
@Builder
public class BillDto {

    private int guestID;
    private UUID watchID;
    private UUID transactionID;
    private ArrayList<BillItemDto> items;
    private int finalPrice;
    private LocalDateTime date;

}
