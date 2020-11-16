package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UsageDto {
    private int id;
    private int guestId;
    private SlideDto slide;
    LocalDateTime timestamp;
}
