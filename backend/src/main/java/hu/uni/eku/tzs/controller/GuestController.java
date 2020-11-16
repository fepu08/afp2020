package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.*;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.model.Usage;
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
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Get all Guests")
    public Collection<GuestDto> getAllGuests(){
        /**ArrayList<SlideDto> slips = new ArrayList<SlideDto>();
        slips.add(SlideDto.builder()
                .ID(1)
                .price(1200)
                .slideCurrentTime(LocalDateTime.now())
                .build());*/
        log.info("Usages debug" + service.getUsagesByTransactionId(service.getTransactionByGuestId(1).getID()).toString());
        return service.getAllGuests().stream().map(model ->
                GuestDto.builder()
                    .ID(model.getID())
                    .arrivalDateTime(model.getArrivalDateTime())
                    .watch(WatchDto.builder()
                            .watchID(service.getWatchByGuestId(model.getID()).getWatchID())
                            .build())
                    .transactions(TransactionDto.builder()
                            .ID(service.getTransactionByGuestId(model.getID()).getID())
                            .slips(service.getUsagesByTransactionId(service.getTransactionByGuestId(model.getID()).getID()).stream().map(usage ->
                                        UsageDto.builder()
                                                .id(usage.getId())
                                                .slide(SlideDto.builder()
                                                        .ID(service.getSlideByUsageId(usage.getId()).getID())
                                                        .price(service.getSlideByUsageId(usage.getId()).getPrice())
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
                            .slips(TransactionDto.builder().build().getSlips())
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
                            .slide(SlideDto.builder()
                                    .ID(service.getSlideById(request.getSlideId()).getID())
                                    .price(service.getSlideById(request.getSlideId()).getPrice())
                                    .build())
                            .timestamp(LocalDateTime.now())
                            .build());

                    service.recordUsage(new Usage(
                            0,
                            new Slide(
                                    service.getSlideById(request.getSlideId()).getID(),
                                    service.getSlideById(request.getSlideId()).getPrice()
                            ),
                            LocalDateTime.now()
                    ), service.getTransactionByGuestId(guest.getID()));



                    log.info("TransactionByGuestId:" + service.getTransactionByGuestId(guest.getID()));
                    log.info("Guest transaction:" + guest.getTransactions());

                    /**log.info(SlideDto.builder()
                     .ID(service.getSlideById(request.getSlideId()).getID())
                     .price(service.getSlideById(request.getSlideId()).getPrice())
                     .slideCurrentTime(LocalDateTime.now())
                     .build().toString());*/
                }
            }
        }
        catch (Exception e)
        {
            log.info(e.getMessage());
            log.info("Nincs ilyen óra használatban: {}", request.getWatchID());
        }
    }

    @PostMapping("/checkOutGuest")
    @ApiOperation(value = "Check out guest")
    public void checkOutGuest(@RequestBody CheckOutGuestRequestDto request){
        service.checkOutGuest(request);
    }
}
