package com.example.service;

import com.example.service.repository.ItemToAddRepository;
import com.example.service.repository.ItemToDeleteRepository;
import com.example.service.service.UpdateServiceImpl;
import com.example.service.util.ItemMapper;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    @Autowired
    private Bus bus;
    @Autowired
    private ItemToDeleteRepository toDeleteRepository;
    @Autowired
    private ItemToAddRepository toAddRepository;
    @Autowired
    private ItemMapper mapper;

    @Bean
    public EndpointImpl getPatchEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new UpdateServiceImpl(toDeleteRepository, toAddRepository, mapper));
        endpoint.publish("/getPatch");
        return endpoint;
    }

}
