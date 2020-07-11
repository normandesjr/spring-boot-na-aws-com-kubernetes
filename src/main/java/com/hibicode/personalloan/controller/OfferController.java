package com.hibicode.personalloan.controller;

import com.hibicode.personalloan.controller.resource.OfferRequest;
import com.hibicode.personalloan.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private static final Logger logger = LoggerFactory.getLogger(OfferController.class);

    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody @Valid OfferRequest offerRequest) {
        logger.info("[OfferController][create] - creating offer: " + offerRequest);
        offerService.save(offerRequest.toDomain());
    }

}
