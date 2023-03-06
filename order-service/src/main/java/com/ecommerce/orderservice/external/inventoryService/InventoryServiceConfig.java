package com.ecommerce.orderservice.external.inventoryService;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryServiceConfig {

    @Value("${inventoryService.host}")
    String inventoryServiceHost;

    @Bean
    public InventoryServiceApi inventoryServiceApi() {
        return Feign.builder()
                .encoder(new JacksonEncoder(new ObjectMapper()))
                .decoder(new JacksonDecoder(new ObjectMapper()))
                .target(InventoryServiceApi.class, inventoryServiceHost);
    }

}
