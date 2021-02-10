package cz.ahraban.thymeleaf.demo.repository;

import cz.ahraban.thymeleaf.demo.entity.ServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<ServerEntity, Integer> {
}
