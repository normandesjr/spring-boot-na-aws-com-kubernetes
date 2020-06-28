package com.hibicode.personalloan.repository;

import com.hibicode.personalloan.repository.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    Optional<OfferEntity> findByActiveTrue();
}
