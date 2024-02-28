package com.kevincode;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import com.kevincode.data.mysql.entitites.ERoleMysqlEntity;
import com.kevincode.data.mysql.entitites.RoleMysqlEntity;
import com.kevincode.data.mysql.entitites.UserMysqlEntity;
import com.kevincode.data.mysql.repositories.UserMysqlRepository;

@SpringBootApplication
public class ArquitectApplication {

	public static void main(String[] args) {
		

		SpringApplication.run(ArquitectApplication.class, args);

		
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserMysqlRepository userMysqlRepository;

	

	@Bean
	CommandLineRunner init(){
		return args -> {

			UserMysqlEntity userMysqlEntity = UserMysqlEntity.builder()  
					.email("santiago@mail.com")
					.username("santiago")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleMysqlEntity.builder()
							.name(ERoleMysqlEntity.valueOf(ERoleMysqlEntity.ADMIN.name()))
							.build()))
					.build();

			UserMysqlEntity userMysqlEntity2 = UserMysqlEntity.builder()
					.email("anyi@mail.com")
					.username("anyi")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleMysqlEntity.builder()
							.name(ERoleMysqlEntity.valueOf(ERoleMysqlEntity.USER.name()))
							.build()))
					.build();

			UserMysqlEntity userMysqlEntity3 = UserMysqlEntity.builder()
					.email("andrea@mail.com")
					.username("andrea")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleMysqlEntity.builder()
							.name(ERoleMysqlEntity.valueOf(ERoleMysqlEntity.INVITED.name()))
							.build()))
					.build();

			userMysqlRepository.save(userMysqlEntity);
			userMysqlRepository.save(userMysqlEntity2);
			userMysqlRepository.save(userMysqlEntity3);
		};
	}

}
