package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long>{

    List<Posting> findByMemberNickname(String memberNickname);

    List<Posting> findByTitle(String title);

    void deleteByTitle(String title);

}
