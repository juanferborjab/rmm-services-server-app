package com.ninjarmm.app.repository;
import com.ninjarmm.app.entity.service.Serve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("serveRepository")
public interface ServeRepository extends JpaRepository<Serve, Long> {

}
