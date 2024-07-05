package com.bezkoder.spring.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootTest
public class SpringBoot3RestApiExampleApplicationTests {

	@Test
	public void contextLoads() {
		SpringApplication.run(SpringBoot3RestApiExampleApplication.class, new String[]{});
	}

	@Test
	public void testMain() {
		SpringBoot3RestApiExampleApplication.main(new String[] {});
	}

	@Test
	public void testMainWithArgs() {
		SpringBoot3RestApiExampleApplication.main(new String[] {"arg1", "arg2"});
	}

	@Test
	public void testMainWithNullArgs() {
		SpringBoot3RestApiExampleApplication.main(null);
	}

}