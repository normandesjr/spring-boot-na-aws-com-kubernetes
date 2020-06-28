package com.hibicode.personalloan.service;

import com.hibicode.personalloan.repository.OfferRepository;
import com.hibicode.personalloan.service.domain.Offer;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void save(Offer offer) {

    }

}
