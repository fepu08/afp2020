package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.*;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Usage;
import hu.uni.eku.tzs.service.GuestService;
import hu.uni.eku.tzs.service.exceptions.AquaparkFullException;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import hu.uni.eku.tzs.service.exceptions.SlideNotFoundByIdException;
import hu.uni.eku.tzs.service.exceptions.WatchNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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
        catch (AquaparkFullException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Get all Guests")
    public Collection<GuestDto> getAllGuests(){
        return service.getAllGuests().stream().map(model ->
                GuestDto.builder()
                    .ID(model.getID())
                    .arrivalDateTime(model.getArrivalDateTime())
                    .watch(WatchDto.builder()
                            .watchID(service.getWatchByGuestId(model.getID()).getWatchID())
                            .build())
                    .transactions(TransactionDto.builder()
                            .ID(service.getTransactionByGuestId(model.getID()).getID())
                            .slips(service.getUsagesByGuestId(model.getID()).stream().map(usage ->
                                        UsageDto.builder()
                                                .id(usage.getId())
                                                .guestId(model.getID())
                                                .slide(SlideDto.builder()
                                                        .ID(service.getSlideByUsageId(usage.getId()).getID())
                                                        .price(service.getSlideByUsageId(usage.getId()).getPrice())
                                                        .slideName(service.getSlideByUsageId(usage.getId()).getSlideName())
                                                        .build())
                                                .timestamp(usage.getTimestamp())
                                                .build()
                                    ).collect(Collectors.toList()))
                            .build())
                    .build()
        ).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/{ID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get guest by id")
    public GuestDto getGuestById(@PathVariable int ID){
        try {
            Guest guest = service.getGuestByID(ID);

            return GuestDto.builder()
                    .ID(guest.getID())
                    .arrivalDateTime(guest.getArrivalDateTime())
                    .watch(WatchDto.builder()
                            .watchID(service.getWatchByGuestId(guest.getID()).getWatchID())
                            .build())
                    .transactions(TransactionDto.builder()
                            .ID(service.getTransactionByGuestId(guest.getID()).getID())
                            .slips(service.getUsagesByGuestId(guest.getID()).stream().map(usage ->
                                        UsageDto.builder()
                                            .id(usage.getId())
                                            .guestId(guest.getID())
                                            .slide(SlideDto.builder()
                                                    .ID(service.getSlideByUsageId(usage.getId()).getID())
                                                    .price(service.getSlideByUsageId(usage.getId()).getPrice())
                                                    .slideName(service.getSlideByUsageId(usage.getId()).getSlideName())
                                                    .build()
                                            )
                                            .timestamp(usage.getTimestamp())
                                            .build()
                                    ).collect(Collectors.toList()))
                            .build())
                    .build();
        } catch (GuestNotFoundByIDException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PostMapping("/useSlide")
    @ApiOperation(value = "Use slide")
    public void useSlide( @RequestBody UseSlideRequestDto request ){
        try {
            Collection<GuestDto> guests = getAllGuests();
            for (GuestDto guest : guests)
            {
                if (request.getWatchID().equals(guest.getWatch().getWatchID())){
                    guest.getTransactions().getSlips().add(UsageDto.builder()
                            .guestId(guest.getID())
                            .slide(SlideDto.builder()
                                    .ID(service.getSlideById(request.getSlideId()).getID())
                                    .price(service.getSlideById(request.getSlideId()).getPrice())
                                    .slideName(service.getSlideById(request.getSlideId()).getSlideName())
                                    .build())
                            .timestamp(LocalDateTime.now())
                            .build());

                    service.recordUsage(new Usage(
                            0,
                            guest.getID(),
                            new Slide(
                                    service.getSlideById(request.getSlideId()).getID(),
                                    service.getSlideById(request.getSlideId()).getPrice(),
                                    service.getSlideById(request.getSlideId()).getSlideName()
                            ),
                            LocalDateTime.now()
                    ), service.getTransactionByGuestId(guest.getID()));
                }
            }
        }
        catch (SlideNotFoundByIdException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping("/checkOutGuest/{ID}")
    @ApiOperation(value = "Check out guest")
    public void checkOutGuest(@PathVariable int ID){
        try {
            service.checkOutGuest(ID);
        }
        catch(GuestNotFoundByIDException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
