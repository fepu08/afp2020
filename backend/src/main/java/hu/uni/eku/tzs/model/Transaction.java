package hu.uni.eku.tzs.model;

import hu.uni.eku.tzs.controller.dto.SlideDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private UUID ID;
    private Collection<Usage> slips;
}
