package yongs.temp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration  
public class Config {
	@LoadBalanced
	@Bean
	public WebClient.Builder loadBalancedWebClientBuilder() {
	    return WebClient.builder();
	}
}
