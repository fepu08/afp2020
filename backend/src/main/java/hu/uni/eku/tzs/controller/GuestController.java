package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.*;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.service.GuestService;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Guest")
@RequiredArgsConstructor
@Api(tags = "Guest Controller")
@Slf4j
public class GuestController {
    private final GuestService service;

    @PostMapping("/checkInGuest")
    @ApiOperation(value = "Check in new guest")
    public void checkInGuest(){
        try {
            service.checkInGuest();
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Get all Guests")
    public Collection<GuestDto> getAllGuests(){
        Collection<Guest> guests = service.getAllGuests();
        Collection<GuestDto> returnDtos = new ArrayList<>();

        for (Guest g : guests){
            returnDtos.add(GuestDto.builder()
                    .ID(g.getID())
                    .arrivalDateTime(g.getArrivalDateTime())
                    /**.watch(WatchDto.builder().watchID(g.getWatch().getWatchID()).build())
                    .transactions(TransactionDto.builder()
                            .ID(g.getTransactions().getID())
                            .slips( g.getTransactions().getSlips().stream().map(
                                    slide -> SlideDto.builder()
                                    .ID(slide.getID())
                                    .price(slide.getPrice())
                                    .slideCurrentTime(slide.getSlideCurrentTime())
                                    .build()).collect(Collectors.toList())
                            )
                            .build())*/
                    .build());
        }

        return returnDtos;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/{ID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get guest by id")
    public GuestDto getGuestById(@PathVariable int ID){
        try {
            Guest guest = service.getGuestByID(ID);

            return GuestDto.builder()
                    .ID(guest.getID())
                    //.watch(WatchDto.builder().watchID(guest.getWatch().getWatchID()).build())
                    .arrivalDateTime(guest.getArrivalDateTime())
                    /**.transactions(TransactionDto.builder()
                            .ID(guest.getTransactions().getID())
                            .slips(guest.getTransactions().getSlips().stream().map(
                                    slide -> SlideDto.builder()
                                            .ID(slide.getID())
                                            .price(slide.getPrice())
                                            .slideCurrentTime(slide.getSlideCurrentTime())
                                            .build()).collect(Collectors.toList())
                            )
                            .build())*/
                    .build();
        } catch (GuestNotFoundByIDException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PostMapping("/checkOutGuest")
    @ApiOperation(value = "Check out guest")
    public void checkOutGuest(@RequestBody CheckOutGuestRequestDto request){
        service.checkOutGuest(request);
    }
}
