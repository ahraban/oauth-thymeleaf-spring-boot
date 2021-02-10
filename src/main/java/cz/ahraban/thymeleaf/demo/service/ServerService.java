package cz.ahraban.thymeleaf.demo.service;

import cz.ahraban.thymeleaf.demo.dto.ServerDto;
import cz.ahraban.thymeleaf.demo.entity.ServerEntity;
import cz.ahraban.thymeleaf.demo.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServerService {


    private final ServerRepository serverRepository;

    @Autowired
    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    public List<ServerDto> getAll(){
        List <ServerEntity> serverEntityList = serverRepository.findAll();
        List<ServerDto> serverDtoList = new ArrayList<>();

        for(ServerEntity serverEntity : serverEntityList){
            serverDtoList.add(new ServerDto(serverEntity));
        }
        return serverDtoList;
    }

    public void addRecord(ServerDto serverDto){
        ServerEntity serverEntity = new ServerEntity();
        serverEntity.setName(serverDto.getName());
        serverEntity.setHostName(serverDto.getHostName());
        serverEntity.setIpAddress(serverDto.getIpAddress());
        serverEntity.setWebURL(serverDto.getWebURL());
        serverRepository.save(serverEntity);
    }
}
