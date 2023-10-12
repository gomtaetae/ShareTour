package com.kosa.ShareTour.entity;

import com.kosa.ShareTour.constant.Role;
import com.kosa.ShareTour.dto.AdminFormDto;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="admins")
@Data
public class Admin {

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)

    private Role role;

    public static Admin createAdmin(AdminFormDto adminFormDto, PasswordEncoder passwordEncoder) {
        Admin admin = new Admin();
        admin.setName(adminFormDto.getName());
        String password = passwordEncoder.encode(adminFormDto.getPassword());
        admin.setPassword(password);
        admin.setRole(Role.ADMIN);
        return admin;
    }
}