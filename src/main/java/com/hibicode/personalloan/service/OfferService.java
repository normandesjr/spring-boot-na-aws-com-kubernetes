package com.hibicode.personalloan.service;

import com.hibicode.personalloan.repository.OfferRepository;
import com.hibicode.personalloan.repository.entity.OfferEntity;
import com.hibicode.personalloan.service.domain.Offer;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.Boolean.FALSE;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void save(Offer offer) {
        Optional<OfferEntity> actualValidOffer = offerRepository.findByActiveTrue();
        actualValidOffer.ifPresent(entity -> entity.setActive(FALSE));

        OfferEntity offerEntity = new OfferEntity(offer);
        offerRepository.save(offerEntity);
    }

}
