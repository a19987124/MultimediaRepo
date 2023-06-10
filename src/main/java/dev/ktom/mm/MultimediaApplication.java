package dev.ktom.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MultimediaApplication {

	@GetMapping("/yay")
	public String message() {
		return "Yay Fernando!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(MultimediaApplication.class, args);
	}

}
