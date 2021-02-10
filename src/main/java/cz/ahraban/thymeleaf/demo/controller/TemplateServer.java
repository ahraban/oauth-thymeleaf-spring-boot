package cz.ahraban.thymeleaf.demo.controller;

import cz.ahraban.thymeleaf.demo.dto.ServerDto;
import cz.ahraban.thymeleaf.demo.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TemplateServer {

    private final ServerService serverService;

    @Autowired
    public TemplateServer(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/servers")
    public String servers(Model model){
        List<ServerDto> serverDtoList = serverService.getAll();

        model.addAttribute("serverDtoList", serverDtoList);
        return "servers";
    }
}
