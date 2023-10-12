package com.kosa.ShareTour.service;

import com.kosa.ShareTour.dto.AdminFormDto;
import com.kosa.ShareTour.entity.Admin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Admin createAdmin(){
        AdminFormDto adminFormDto = new AdminFormDto();
        adminFormDto.setName("홍길동");
        adminFormDto.setPassword("12345678");

        return Admin.createAdmin(adminFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        Admin admin = createAdmin();
        Admin savedAdmin = adminService.saveAdmin(admin);

        assertEquals(admin.getName(), savedAdmin.getName());
        assertEquals(admin.getPassword(), savedAdmin.getPassword());
        assertEquals(admin.getRole(), savedAdmin.getRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateAdminTest(){
        Admin admin1 = createAdmin();
        Admin admin2 = createAdmin();
        adminService.saveAdmin(admin1);

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            adminService.saveAdmin(admin2);});
        assertEquals("이미 가입된 회원입니다.", e.getMessage());
    }



}