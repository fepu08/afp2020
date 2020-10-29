package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.*;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
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

    @PostMapping("/recordNewGuest")
    @ApiOperation(value = "record New Guest")
    public void recordNewGuest(){
        GuestDto guest = GuestDto.builder()
                .watch(WatchDto.builder().watchID(UUID.randomUUID()).build())
                .ID(UUID.randomUUID())
                .transactions(TransactionDto.builder()
                        .ID(UUID.randomUUID())
                        .slips(new ArrayList<>())
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
                    .transactions(guest.getTransactions())
                    .arrivalDateTime(guest.getArrivalDateTime())
                    .build();
        }).collect(Collectors.toList());
    }

    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get guest by id")
    public GuestDto getGuestByID(@PathVariable UUID ID) throws GuestNotFoundByIDException {
        for (GuestDto guest : guests){
            if (guest.getID().equals(ID)){
                return GuestDto.builder()
                        .watch(guest.getWatch())
                        .ID(guest.getID())
                        .transactions(guest.getTransactions())
                        .arrivalDateTime(guest.getArrivalDateTime())
                        .build();
            }
        }

        throw new GuestNotFoundByIDException();
    }

    @GetMapping(value = {"/slips/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get guest slips by id")
    public Collection<SlideDto> getSlideUsageOfGuestByID(@PathVariable UUID ID){

        Collection<SlideDto> slips = new ArrayList<>();

        for (GuestDto guest : guests){
            if (guest.getID().equals(ID)){
                slips = guest.getTransactions().getSlips();
            }
        }

        return slips;
    }

    @PostMapping("/useSlide")
    @ApiOperation(value = "Use slide")
    public void useSlide( @RequestBody UseSlideRequestDto request ){

        try {
            for (GuestDto guest : guests)
            {       //  !!!!!!  UUID-nál nem == hanem .equals() kell  !!!!!!
                if (request.getWatchID().equals(guest.getWatch().getWatchID())){

                    // Hozzá adjuk a csuszda árát és ID-jet a tranzakciós listához
                    guest.getTransactions().getSlips().add(
                            SlideDto.builder()
                                    .ID(request.getSlideId())
                                    .price(request.getPrice())
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