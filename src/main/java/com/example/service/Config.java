package com.example.service;

import com.example.service.repository.ItemToAddRepository;
import com.example.service.repository.ItemToDeleteRepository;
import com.example.service.service.UpdateServiceImpl;
import com.example.service.util.ItemMapper;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    private final Bus bus;
    private final ItemToDeleteRepository toDeleteRepository;
    private final ItemToAddRepository toAddRepository;
    private final ItemMapper mapper;

    public Config(Bus bus, ItemToDeleteRepository toDeleteRepository,
                  ItemToAddRepository toAddRepository, ItemMapper mapper) {
        this.bus = bus;
        this.toDeleteRepository = toDeleteRepository;
        this.toAddRepository = toAddRepository;
        this.mapper = mapper;
    }

    @Bean
    public EndpointImpl getPatchEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new UpdateServiceImpl(toDeleteRepository, toAddRepository, mapper));
        endpoint.publish("/getPatch");
        return endpoint;
    }

}
