package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class UsageDto {
    private UUID ID;
    private SlideDto slideID;

}
