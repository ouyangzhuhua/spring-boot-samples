package com.ilinux.springbootbasis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootTest
@Slf4j
class SpringbootBasisApplicationTests {

	@Test
	void contextLoads() {
		log.info(new BCryptPasswordEncoder().encode("admin"));
//		log.info(Base64.getEncoder().encodeToString("jude:jude".getBytes()));
//		byte[] base64Token = "Basic anVkZTpqdWRl".substring(6).getBytes(StandardCharsets.UTF_8);
//		log.info(new String(Base64.getDecoder().decode("base64Token"), StandardCharsets.UTF_8));
	}



}
