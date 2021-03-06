package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.*;
import hu.uni.eku.tzs.model.Guest;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.service.SlideService;
import hu.uni.eku.tzs.service.exceptions.GuestNotFoundByIDException;
import hu.uni.eku.tzs.service.exceptions.SlideAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.SlideNotFoundByIdException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.nio.channels.ReadPendingException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Slide")
@RequiredArgsConstructor
@Api(tags = "Slide controller")
@Slf4j
public class SlideController {
    private final SlideService slideService;

    @PostMapping("/record")
    @ApiOperation(value = "Create new slide")
    public void createSlide(@RequestBody SlideCreateRequestDto request){
        try {
            slideService.create(new Slide(
                            0,
                            request.getPrice(),
                            request.getSlideName()
                    )
            );
        }
        catch(SlideAlreadyExistsException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Get all slides")
    public Collection<SlideDto> getAllSlides(){
        return slideService.getAllSlides().stream().map(model->
                SlideDto.builder()
                .ID(model.getID())
                .price(model.getPrice())
                .slideName(model.getSlideName())
                .build()
                ).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/{ID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get slide by id")
    public SlideDto getSlideById(@PathVariable int ID){
        try {
            Slide slide = slideService.getSlideById(ID);

            return SlideDto.builder()
                    .ID(slide.getID())
                    .price(slide.getPrice())
                    .slideName(slide.getSlideName())
                    .build();
        } catch (SlideNotFoundByIdException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping(value = {"/{ID}"})
    @ApiOperation(value = "Delete a slide by id")
    public void delete(@PathVariable int ID) {
        try {
            slideService.delete(ID);
        } catch (SlideNotFoundByIdException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping(value = {"/{ID}"})
    @ApiOperation(value = "Update slide by id")
    public void updateSlide(@PathVariable int ID, @RequestBody SlideCreateRequestDto request) {
        try {
            slideService.update(ID, new Slide(
                    0,
                    request.getPrice(),
                    request.getSlideName()
            ));
        } catch(SlideNotFoundByIdException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
