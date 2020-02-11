package com.ilinux.springbootbasis.config;

import com.ilinux.springbootbasis.configproperty.Users;
import com.ilinux.springbootbasis.security.MyUserDetailService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableConfigurationProperties({Users.class})
public class AppConfig {

    @Bean
    public UserDetailsService userDetailsService(Users users) {
        return new MyUserDetailService(users);
    }
}
