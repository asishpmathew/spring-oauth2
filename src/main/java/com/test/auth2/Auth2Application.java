package com.test.auth2;

import com.test.auth2.entity.User;
import com.test.auth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Auth2Application {

	@Autowired
	private UserRepository  userRepository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(new User(101, "asish","test", "asish.mathew@ibsplc.com") ,
				new User(102, "ann","test1", "ann@ibsplc.com"),
				new User(103, "arun","test11", "arun@ibsplc.com")).collect(Collectors.toList());
		userRepository.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(Auth2Application.class, args);
	}

}
