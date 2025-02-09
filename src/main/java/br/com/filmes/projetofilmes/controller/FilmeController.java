package br.com.filmes.projetofilmes.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.filmes.projetofilmes.dto.FilmeDto;
import br.com.filmes.projetofilmes.entity.Filme;
import br.com.filmes.projetofilmes.service.ApiService;
import br.com.filmes.projetofilmes.service.FilmeService;

@RestController
@RequestMapping(value = "/series")
public class FilmeController {

    @Value("${api.key}")
    private String apiKey;

    private final ApiService apiService;
    private final FilmeService filmeService;

    public FilmeController(ApiService apiService, FilmeService filmeService) {
        this.apiService = apiService;
        this.filmeService = filmeService;
    }

    @GetMapping("/frases/{titulo}")
    public ResponseEntity<FilmeDto> buscaFilme(@PathVariable("titulo") String titulo) {
        FilmeDto filme = apiService.filmeDto(titulo, apiKey); // Passa o título como parâmetro
        return ResponseEntity.ok(filme);
    }

    @PostMapping("/frases/{titulo}")
    public Filme saveFilme(@PathVariable("titulo") String titulo) {
        return filmeService.saveFilme(titulo);
    }

    @GetMapping("/frases")
    public ResponseEntity<List<FilmeDto>> list() {
        List<FilmeDto> filmesDto = filmeService.list().stream()
                .map(filme -> new FilmeDto(filme.getTitle(), filme.getPoster(), filme.getPlot(), filme.getActors()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(filmesDto);
    }

    @DeleteMapping("/frases/{id}")
    public ResponseEntity<List<Filme>> delete(@PathVariable("id")Long id) {
        return ResponseEntity.ok().body(filmeService.delete(id));
    }
}


