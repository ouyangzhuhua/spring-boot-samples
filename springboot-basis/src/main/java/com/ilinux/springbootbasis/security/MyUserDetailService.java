package com.ilinux.springbootbasis.security;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.ilinux.springbootbasis.configproperty.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private Users users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.getUsers().stream().map(this::toUser).filter(u -> u.getUsername().equals(username)).findFirst().get();
    }

    private User toUser(String userStr) {
        ArrayList<String> fields = Lists.newArrayList(Splitter.on(":").omitEmptyStrings().trimResults().split(userStr));

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        Splitter.on("|").omitEmptyStrings().trimResults().split(fields.get(2)).forEach(s -> grantedAuthorityList.add(new SimpleGrantedAuthority(s)));

        return new User(fields.get(0), fields.get(1), grantedAuthorityList);

    }
}
