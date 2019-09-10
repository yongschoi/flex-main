package yongs.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FlexMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlexMainApplication.class, args);
	}
}
