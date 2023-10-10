package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findByCountry(String country);
    List<Place> findByProvince(String province);
    List<Place> findByCity(String city);
}
