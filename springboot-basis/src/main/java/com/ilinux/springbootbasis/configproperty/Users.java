package com.ilinux.springbootbasis.configproperty;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "spring.security")
public class Users {
    private List<String> users;
}
