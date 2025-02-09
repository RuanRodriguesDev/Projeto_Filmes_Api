package br.com.filmes.projetofilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class ProjetofilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetofilmesApplication.class, args);
	}

}
