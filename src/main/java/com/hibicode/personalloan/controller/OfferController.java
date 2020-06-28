package com.hibicode.personalloan.controller;

import com.hibicode.personalloan.controller.resource.OfferRequest;
import com.hibicode.personalloan.service.OfferService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody @Valid OfferRequest offerRequest) {
        offerService.save(offerRequest.toDomain());
    }

}
