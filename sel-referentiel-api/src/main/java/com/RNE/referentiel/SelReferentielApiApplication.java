package com.RNE.referentiel;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.RNE.referentiel.dto.mappers.SectionMapper;

@SpringBootApplication
@ComponentScan(basePackages = "com.RNE")
public class SelReferentielApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelReferentielApiApplication.class, args);
    }

    @Bean
    public SectionMapper sectionMapper() {
        return Mappers.getMapper(SectionMapper.class);
    }

}