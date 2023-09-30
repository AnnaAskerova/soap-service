package com.example.service;

import com.example.service.service.UpdateServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Autowired
    private Bus bus;

    @Bean
    public EndpointImpl getPatchEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new UpdateServiceImpl());
        endpoint.publish("/getPatch");
        return endpoint;
    }

}
