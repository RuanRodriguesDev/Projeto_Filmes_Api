package br.com.filmes.projetofilmes.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.filmes.projetofilmes.dto.FilmeDto;


@FeignClient(name = "Apifilmes", url = "https://www.omdbapi.com/")
public interface ApiService {

    // Usar o parâmetro 'apikey' corretamente
    @GetMapping
    FilmeDto filmeDto(@RequestParam("t") String titulo, @RequestParam("apikey") String key);
}
