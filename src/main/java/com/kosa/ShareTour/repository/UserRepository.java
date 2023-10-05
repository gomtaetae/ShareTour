package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{


    List<User> findByUsername(String username);
    User findByEmail(String email);
    User findByNickname(String nickname);
//    void deleteByUsersidIn(List<Integer> userIdToDelete);

}