package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import yongs.temp.service.EmployeeService;
import yongs.temp.service.ProjectService;

@RestController
@RequestMapping("/main")
public class MainController {
	private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    EmployeeService eService;

    @Autowired
    ProjectService pService;
    
    @GetMapping("")
    public Flux<?> getMain() throws Exception{
    	logger.debug("flex-main|MainController|getMain()");
    	
    	return eService.getEmployees();
    }
}