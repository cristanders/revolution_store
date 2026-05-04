package com.cristianperez.revolutionstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RevolutionstoreApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(RevolutionstoreApplication.class, args);
    }

    @Override

    public void run(String... args) throws Exception {
        System.out.println("store working properly");
    }
}