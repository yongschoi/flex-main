package yongs.temp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import yongs.temp.vo.Employee;
import yongs.temp.vo.Project;
import yongs.temp.vo.Tech;

@Service
public class ProjectService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);
    
    /* Target URL */
	// private static String EMPLOYEES_URI = "http://flex-employee/employees";
	// private static String PROJECTS_URI = "http://flex-project/projects";
	// private static String TECHS_URI = "http://flex-tech/techs";

	// private static String EMPLOYEES_URI = "http://127.0.0.1:8081/employees";
	private static String PROJECTS_URI = "http://127.0.0.1:8082/projects";
	private static String PROJECT_TEST_URI = "http://127.0.0.1:8082/test";
	// private static String TECHS_URI = "http://127.0.0.1:8083/techs";
	
	@Autowired
    WebClient.Builder webClientBuilder;	
    
    public Flux<Project> getProjects() throws Exception{
    	logger.debug("flex-main|MainService|getProjects()");
    	  	
    	Flux<Project> response = webClientBuilder.build().get()
    			.uri(PROJECTS_URI)
    			.retrieve()
    			.bodyToFlux(Project.class);
      
        return response; 	
    }

    public Flux<String> getTest() throws Exception{    
    	logger.debug("flex-main|ProjectService|getTest()");
    	Flux<String> response = webClientBuilder.build().get()
    			.uri(PROJECT_TEST_URI)
    			.retrieve()
    			.bodyToFlux(String.class);
     
        return response; 	
    }
/*   
    public Flux<Tech> getTechs() throws Exception{
    	logger.debug("flex-main|MainService|getTechs()");
    	WebClient webClient = WebClient.create();
    	
    	Flux<Tech> responseFlux = webClient.get()
    			.uri(TECHS_URI)
    			.retrieve()
    			.bodyToFlux(Tech.class);
        
        return responseFlux; 	
    }
*/    
}