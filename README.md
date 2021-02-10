# oauth-thymeleaf-spring-boot
Simple Oauth app
- GUI: http://localhost:8080/servers
- 2 REST endpoints ()
  - /api/addserver  = POST method expecting JSON request body:
        {
        "name" : "server name",
        "hostName" : "hostname",
        "ipAddress" : "123.123.54.654",
        "webURL" : "www.google.com"    
        }
  - /api/getAll = GET method returns all servers
- javascript REST oauth2 not implemented
