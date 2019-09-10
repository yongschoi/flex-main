package yongs.temp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import yongs.temp.vo.Employee;
import yongs.temp.vo.Project;
import yongs.temp.vo.Tech;

@Service
public class MainService {
    private static final Logger logger = LoggerFactory.getLogger(MainService.class);
    
    /* Target URL */
	private static String EMPLOYEES_URI = "http://flex-employee/employees";
	private static String PROJECTS_URI = "http://flex-project/projects";
	private static String TECHS_URI = "http://flex-tech/techs";
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
    public Flux<Employee> getEmployees() throws Exception{
    	logger.debug("flex-main|MainService|getEmployees()");
    	
    	Flux<Employee> responseFlux = webClientBuilder.build().get()
    			.uri(EMPLOYEES_URI)
    			.retrieve()
    			.bodyToFlux(Employee.class);
        
        return responseFlux; 	
    }
    
    public Flux<Project> getProjects() throws Exception{
    	logger.debug("flex-main|MainService|getProjects()");
    	
    	Flux<Project> responseFlux = webClientBuilder.build().get()
    			.uri(PROJECTS_URI)
    			.retrieve()
    			.bodyToFlux(Project.class);
        
        return responseFlux; 	
    }
    
    public Flux<Tech> getTechs() throws Exception{
    	logger.debug("flex-main|MainService|getTechs()");
    	
    	Flux<Tech> responseFlux = webClientBuilder.build().get()
    			.uri(TECHS_URI)
    			.retrieve()
    			.bodyToFlux(Tech.class);
        
        return responseFlux; 	
    }
}