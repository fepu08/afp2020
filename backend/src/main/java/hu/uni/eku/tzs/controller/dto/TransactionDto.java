package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;
import org.jboss.jandex.TypeTarget;

import java.util.Collection;
import java.util.UUID;

@Data
@Builder
public class TransactionDto {
    private UUID ID;
    private Collection<UsageDto> slips;
}
