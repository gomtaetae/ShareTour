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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("관리자 생성 테스트")
    public void createAdminList(){
        // given
        Admin admin = STUtils.getAdmin();

        adminRepository.saveAndFlush(admin);
        em.clear();

        //when
        var savedAdmin = adminRepository.findById(admin.getId()).orElseThrow();

        // then
        assertThat(savedAdmin.getName()).isEqualTo(admin.getName());
        System.out.println(savedAdmin);
    }

    @Test
    @DisplayName("관리자 이름으로 조회 테스트")
    public void findByAdminNmTest(){
        //given
        String adminName = "관리자1";

        for (int i = 1; i <= 3; i++) {
            Admin admin = STUtils.getAdmin(String.valueOf(i));
            adminRepository.saveAndFlush(admin);
        }
        em.clear();

        //when
        var targetAdmin = adminRepository.findByName(adminName);

        // then
        assertThat(targetAdmin.getName()).isNotNull();
        assertThat(targetAdmin.getName()).isEqualTo(adminName);
    }

    @Test
    @DisplayName("관리자 이름 구분 삭제 테스트")
    public void deleteAdminsByNameTest(){
        // given
        for (int i = 1; i <= 3; i++) {
            Admin admin = STUtils.getAdmin(String.valueOf(i));
            adminRepository.saveAndFlush(admin);
        }
        em.clear();

        //when
        adminRepository.deleteByName("관리자1");

        //then
        var adminList = adminRepository.findAll();
        assertThat(adminList.size()).isEqualTo(2);
    }


}