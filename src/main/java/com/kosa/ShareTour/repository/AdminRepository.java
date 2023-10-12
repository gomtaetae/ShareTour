package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByName(String name);
    void deleteByName(String name);

}
