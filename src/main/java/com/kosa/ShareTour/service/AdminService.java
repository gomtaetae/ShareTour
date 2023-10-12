package com.kosa.ShareTour.service;

import com.kosa.ShareTour.entity.Admin;
import com.kosa.ShareTour.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public Admin saveAdmin(Admin admin){
        validateDuplicateAdmin(admin);
        return adminRepository.save(admin);
    }

    private void validateDuplicateAdmin(Admin admin){
        Admin findAdmin = adminRepository.findByName(admin.getName());
        if(findAdmin != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByName(name);

        if(name == null){
            throw new UsernameNotFoundException(name);
        }

        return User.builder()
                .username(admin.getName())
                .password(admin.getPassword())
                .roles(admin.getRole().toString())
                .build();
    }


}
