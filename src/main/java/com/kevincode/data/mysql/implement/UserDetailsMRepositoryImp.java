package com.kevincode.data.mysql.implement;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kevincode.data.mysql.entitites.UserMysqlEntity;
import com.kevincode.data.mysql.repositories.UserMysqlRepository;

@Service
public class UserDetailsMRepositoryImp implements UserDetailsService {
    @Autowired
    private UserMysqlRepository userMysqlRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserMysqlEntity userMysqlEntity = userMysqlRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        Collection<? extends GrantedAuthority> authorities = userMysqlEntity.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                .collect(Collectors.toSet());

        return new User(userMysqlEntity.getUsername(),
                userMysqlEntity.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }
}
