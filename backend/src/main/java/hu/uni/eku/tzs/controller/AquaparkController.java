package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Aquapark")
@RequiredArgsConstructor
@Api(tags = "Aquapark")
@Slf4j
public class AquaparkController {

    private Collection<GuestDto> guests = new ArrayList<>();

    @PostMapping("/record New Guest")
    @ApiOperation(value = "recordNewGuest")
    public void recordNewGuest(){
        GuestDto guest = GuestDto.builder()
                .watch(WatchDto.builder().watchID(UUID.randomUUID()).build())
                .ID(UUID.randomUUID())
                .transactionID(TransactionDto.builder()
                        .ID(UUID.randomUUID())
                        .usages(new ArrayList<>())
                        .build())
                .arrivalDateTime(LocalDateTime.now())
                .build();
        guests.add(guest);
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get all guest")
    public Collection<GuestDto> getAllGuests(){
        return guests.stream().map(guest -> {
              return GuestDto.builder()
                    .watch(guest.getWatch())
                    .ID(guest.getID())
                    .transactionID(guest.getTransactionID())
                    .arrivalDateTime(guest.getArrivalDateTime())
                    .build();
        }).collect(Collectors.toList());
    }

    @PostMapping("/slideUsage")
    @ApiOperation(value = "slide usage")
    public void slideUsage( @RequestBody SlideUsageRequestDto request ){

        try {
            for (GuestDto guest : guests)
            {       //  !!!!!!  UUID-nál nem == hanem .equals() kell  !!!!!!
                if (request.getWatchID().equals(guest.getWatch().getWatchID())){

                    guest.getTransactionID().getUsages().add(
                            UsageDto.builder()
                                    .ID(UUID.randomUUID())
                                    .slideID(SlideDto.builder()
                                            .ID(request.getSlideId())
                                            .price(request.getPrice())
                                            .build())
                                    .build()
                    );
                }
            }
        }
        catch (Exception e)
        {
            log.info("Nincs ilyen óra használatban: {}", request.getWatchID());
        }
    }
}