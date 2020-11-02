package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SlideDto {
    private int ID;
    private int price;
    private LocalDateTime slideCurrentTime;
}
