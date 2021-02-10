package cz.ahraban.thymeleaf.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.ahraban.thymeleaf.demo.dto.ServerDto;
import cz.ahraban.thymeleaf.demo.service.ServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class RestServer {
    static Logger logger = LoggerFactory.getLogger(RestServer.class.getName());
    private final ServerService serverService;

    @Autowired
    public RestServer(ServerService serverService) {
        this.serverService = serverService;
    }


    @RequestMapping(value = "/addserver", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> addServer(@RequestBody ServerDto serverDto) throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(" --- server dto: " + serverDto);
        serverService.addRecord(serverDto);

        //get all existing records
        String body = " --- response body --- ";

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(body);
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getRecords() throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //get all existing records
        String body =serverService.getAll().toString();
        //String body = "watchService.getAllWatches()";

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(body);

    }


}
