package yongs.temp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import yongs.temp.vo.Employee;

@Component
@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    /* Target URL */
    @Value("${api.uri.employee}")
    private String employeeUrl;
	
	@Autowired
    WebClient.Builder webClientBuilder;		
	
    public Flux<Employee> getEmployees() throws Exception{
    	logger.debug("flex-main|MainService|getEmployees()");
    	
    	String EMPLOYEES_URI = "http://" + employeeUrl + "/employees";
    	
    	Flux<Employee> response = webClientBuilder.build().get()
    			.uri(EMPLOYEES_URI)
    			.retrieve()
    			.bodyToFlux(Employee.class);
     
        return response; 	
    } 
}