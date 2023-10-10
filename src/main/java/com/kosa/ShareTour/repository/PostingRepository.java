package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Integer>{


    List<Posting> findByMemberNickname(String userNickname);

    List<Posting> findByTitle(String title);

    void deleteByTitle(String title);

}
