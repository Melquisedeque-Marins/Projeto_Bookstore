package br.com.melck.projeto_bookstore.config;

import br.com.melck.projeto_bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaBaseDeDados(){
        this.dbService.instanciaBaseDeDados();

    }
    
}
