package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Admin;
import com.kosa.ShareTour.utils.STUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AdminRepositoryTest {

    @Autowired
    UserRepository adminRepository;

}