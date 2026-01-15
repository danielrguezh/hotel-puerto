package org.docencia.hotel.config;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.docencia.hotel.web.soap.impl.GuestSoapServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class CxfConfig {
    private final GuestSoapServiceImpl guestSoapEndPoint;
    private final Bus bus;


    public CxfConfig(GuestSoapServiceImpl guestSoapEndPoint, Bus bus) {
        this.guestSoapEndPoint = guestSoapEndPoint;
        this.bus=bus;
    }
    

    @Bean
    public Endpoint guestEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, guestSoapEndPoint);
        endpoint.publish("/guest");
        return endpoint;
    }
}
