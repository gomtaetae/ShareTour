package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{

//    //패키지 제목으로 찾기(여럿)
//    List<Package> findByPackageTitle(String title);
//
//    //패키지 시작일로 찾기(여럿)
//    List<Package> findByPackageStartDate(LocalDate startDate);
//
//    //패키지 마지막일로 찾기(여럿)
//    List<Package> findByPackageEndDate(LocalDate endDate);
//
//    //패키지 총 기간으로 찾기(여럿)
//    List<Package> findByPackageDuration(int duration);
//
//    //패키지 국가별로 찾기(여럿)
//    List<Package> findByPlaceCountry(String country);
//
//    //패키지 '도'별로 찾기(여럿)
//    List<Package> findByPlaceProvince(String province);
//
//    //패키지 '시'별로 찾기(여럿)
//    List<Package> findByPlaceCity(String city);
//
//    //패키지 명소 이름으로 찾기(여럿)
//    List<Package> findByLandmarkName(String landmarkName);
//
//    //패키지 명소 종류로 찾기(여럿)
//    List<Package> findByLandmarkCategory(String landmarkCategory);
//
//    //
//    List<Package> findByLandmarkArea(String landmarkArea);
//
////    List<Package>

}
