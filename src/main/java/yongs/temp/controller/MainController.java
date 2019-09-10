package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import yongs.temp.service.MainService;

@RestController
@RequestMapping("/main")
public class MainController {
	private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MainService service;
    
    @GetMapping("")
    public Flux<?> getMain() throws Exception{
    	logger.debug("flex-main|MainController|getMain()");
    	
    	StopWatch stopWatch = new StopWatch("flex-main");
    	stopWatch.start();   	
    	
    	Flux<?> result = Flux.concat(Flux.concat(service.getEmployees(), service.getProjects()), service.getTechs());   	
    	
    	stopWatch.stop();
        System.out.println(stopWatch.shortSummary());
        
    	return result;
    }
}