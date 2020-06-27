package com.hibicode.personalloan.controller;

import com.hibicode.personalloan.controller.resource.OfferRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @PostMapping
    public void create(@RequestBody @Valid OfferRequest offerRequest) {
        System.out.println(offerRequest);
    }

}
