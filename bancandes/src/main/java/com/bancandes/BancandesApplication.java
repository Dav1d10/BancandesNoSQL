package com.bancandes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bancandes.repository.CuentaRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.bancandes.mongodb.repository")
public class BancandesApplication implements CommandLineRunner {


    @Autowired
    CuentaRepository cuentaRepository;
    public static void main( String[] args ) {
        SpringApplication.run(BancandesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bancandes fue inicializada correctamente...");
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
}
