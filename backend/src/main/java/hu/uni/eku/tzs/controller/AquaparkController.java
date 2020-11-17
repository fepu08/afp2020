package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.*;
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
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Aquapark")
@RequiredArgsConstructor
@Api(tags = "Aquapark")
@Slf4j
public class AquaparkController {

    private int guestID = 0;
    private Collection<GuestDto> guests = new ArrayList<>();
    private static Queue<WatchDto> watches = new LinkedList<>();
    
    static {
        for (int i = 0; i < 10; i++) {
            watches.add(WatchDto.builder().watchID(UUID.randomUUID()).build());
        }
    }

    @PostMapping("/checkInGuest")
    @ApiOperation(value = "Check in new guest")
    public void checkInGuest(){
        if (!watches.isEmpty()) {
            GuestDto guest = GuestDto.builder()
                    .watch(watches.poll())
                    .ID(guestID++)
                    .transactions(TransactionDto.builder()
                            .ID(UUID.randomUUID())
                            .slips(new ArrayList<>())
                            .build())
                    .arrivalDateTime(LocalDateTime.now())
                    .build();
            guests.add(guest);

        }
        else {
            log.info("Nincs több szabad hely az aquaparkban.");
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Nincs több szabad hely az aquaparkban."
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get all guests")
    public Collection<GuestDto> getAllGuests(){
        return guests.stream().map(guest -> GuestDto.builder()
              .watch(guest.getWatch())
              .ID(guest.getID())
              .transactions(guest.getTransactions())
              .arrivalDateTime(guest.getArrivalDateTime())
              .build()).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/{ID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get guest by id")
    public GuestDto getGuestByID(@PathVariable int ID) throws GuestNotFoundByIDException {
        for (GuestDto guest : guests){
            if (guest.getID() == ID){
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

    @RequestMapping(method = RequestMethod.GET, value = {"/slips/{ID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get guest slips by id")
    public Collection<SlideDto> getSlideUsageOfGuestByID(@PathVariable int ID){

        Collection<SlideDto> slips = new ArrayList<>();

        /**for (GuestDto guest : guests){
            if (guest.getID() == ID){
                slips = guest.getTransactions().getSlips();
            }
        }*/

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
                    /**guest.getTransactions().getSlips().add(
                            SlideDto.builder()
                                    .ID(request.getSlideId())
                                    //.price(request.getPrice())
                                    .slideCurrentTime(LocalDateTime.now())
                                    .build()
                    );*/
                }
            }
        }
        catch (Exception e)
        {
            log.info("Nincs ilyen óra használatban: {}", request.getWatchID());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/bill/{ID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Generate bill for the guest")
    public BillDto getBillOfGuest(@PathVariable int ID) throws GuestNotFoundByIDException {
        GuestDto guest = getGuestByID(ID);
        int finalPrice = 0;

        BillDto bill = BillDto.builder()
                .guestID(guest.getID())
                .watchID(guest.getWatch().getWatchID())
                .transactionID(guest.getTransactions().getID())
                .items(new ArrayList<>())
                .date(LocalDateTime.now())
                .build();

        /**for (SlideDto slip : guest.getTransactions().getSlips()){
            boolean itemExist = false;

            BillItemDto newBillItem = BillItemDto.builder()
                    .slideID(slip.getID())
                    .slidePrice(slip.getPrice())
                    .counter(1)
                    .slideFinalPrice(slip.getPrice())
                    .build();

            if (bill.getItems().size() == 0)
            {
                bill.getItems().add(newBillItem);
            }
            else {
                for (BillItemDto billItem : bill.getItems()){
                    if(billItem.getSlideID() == slip.getID()){
                        itemExist = true;
                        billItem.setCounter(billItem.getCounter() + 1);
                        billItem.setSlideFinalPrice(billItem.getSlideFinalPrice() + slip.getPrice());
                        break;
                    }
                }
                if (!itemExist){
                    bill.getItems().add(newBillItem);
                }
            }

            finalPrice += slip.getPrice();
        }*/

        bill.setFinalPrice(finalPrice);

        return bill;
    }

    @PostMapping("/checkOutGuest")
    @ApiOperation(value = "Check out guest")
    public void checkOutGuest(@RequestBody CheckOutGuestRequestDto request) throws GuestNotFoundByIDException {
        GuestDto guest = getGuestByID(request.getGuestID());
        guests.remove(guest);
        watches.add(guest.getWatch());
    }
}