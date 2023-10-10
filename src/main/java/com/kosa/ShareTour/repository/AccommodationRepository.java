package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {

    List<Accommodation> findByName(String name);
    Accommodation findByArea(String area);
    Accommodation findByprice(float price);
}
