package ru.fmd.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class StorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageApplication.class, args);
	}

}
