package cz.ahraban.thymeleaf.demo.dto;

import cz.ahraban.thymeleaf.demo.entity.ServerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerDto {
    long id;
    String name;
    String hostName;
    String ipAddress;
    String webURL;

    public ServerDto(){};

    public ServerDto(ServerEntity serverEntity){
        this.name = serverEntity.getName();
        this.hostName = serverEntity.getHostName();
        this.ipAddress = serverEntity.getIpAddress();
        this.webURL = serverEntity.getWebURL();
    }

    @Override
    public String toString(){
        return "Name: " + this.getName()
                + " Hostname: " + this.getHostName()
                + " Ip Address: " + this.getIpAddress()
                + " WebURL: " + this.getWebURL();
    }
}
