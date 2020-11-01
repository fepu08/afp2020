package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BillItemDto {
    private int slideID;
    private int slidePrice;
    private int counter;
    private int slideFinalPrice;
}
