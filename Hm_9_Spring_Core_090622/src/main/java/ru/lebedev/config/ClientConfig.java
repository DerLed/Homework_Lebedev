package ru.lebedev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.lebedev.core.entity.Client;

@Configuration
public class ClientConfig {

    private static final String PROTO_SCOPE = "prototype";

    @Bean
    @Scope(PROTO_SCOPE)
    public Client client(){
        return new Client();
    }
}
