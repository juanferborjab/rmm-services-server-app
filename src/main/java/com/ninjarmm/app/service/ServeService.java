package com.ninjarmm.app.service;


import com.ninjarmm.app.repository.ServeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ninjarmm.app.entity.service.Serve;


@Service
public class ServeService {
    @Autowired
    ServeRepository serveRepository;

    public Serve findById(Long idService) {
        return serveRepository.findById(idService).orElseThrow(() -> new RuntimeException("Service not found!"));
    }

}
