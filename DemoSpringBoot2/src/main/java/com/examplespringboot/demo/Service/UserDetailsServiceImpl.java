package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Entity.CustomUserDetails;
import com.examplespringboot.demo.Entity.User;
import com.examplespringboot.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("khong tim thay quyen");
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        CustomUserDetails customUserDetails = new CustomUserDetails(user.getEmail()
                , user.getPassword(), authorities);
        customUserDetails.setId(user.getId());
        customUserDetails.setFullname(user.getFullname());
        customUserDetails.setAvatar(user.getAvatar());
        return customUserDetails;
    }



}
