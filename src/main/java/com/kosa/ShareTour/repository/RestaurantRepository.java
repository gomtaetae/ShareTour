package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Accommodation;
import com.kosa.ShareTour.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

    Restaurant findByAddress(String address);
    List<Restaurant> findByName(String name);
    List<Restaurant> findByArea(String area);
    List<Restaurant> findByParking(String parking);

}
