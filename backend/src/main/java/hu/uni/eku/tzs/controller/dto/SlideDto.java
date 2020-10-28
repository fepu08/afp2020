package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlideDto {
    private int ID;
    private int price;
}
