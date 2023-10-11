package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface LandmarkRepository extends JpaRepository<Landmark, Integer>{

    Landmark findByAddress(String address);
    List<Landmark> findByName(String name);
    List<Landmark> findByArea(String area);
    List<Landmark> findByCategory(String category);
    List<Landmark> findByParking(String parking);

}
