package br.com.filmes.projetofilmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.filmes.projetofilmes.dto.FilmeDto;
import br.com.filmes.projetofilmes.entity.Filme;
import br.com.filmes.projetofilmes.repository.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final ApiService apiService;

    // Injeta a chave da API a partir do arquivo application.properties
    @Value("${api.key}")
    private String apiKey;

    public FilmeService(FilmeRepository filmeRepository, ApiService apiService) {
        this.filmeRepository = filmeRepository;
        this.apiService = apiService;
    }

    public Filme saveFilme(String titulo) {
        // Busca os detalhes do filme usando a API
        FilmeDto filmeDto = apiService.filmeDto(titulo, apiKey);

        if (filmeDto == null || filmeDto.getTitle() == null) {
            throw new RuntimeException("Filme não encontrado na API OMDB");
        }

        // Converte FilmeDto para entidade Filme
        Filme filmeEntity = new Filme(
                null, // ID será gerado automaticamente
                filmeDto.getTitle(),
                filmeDto.getPoster(),
                filmeDto.getPlot(),
                filmeDto.getActors());

        // Salva o filme no banco e retorna a entidade salva
        return filmeRepository.save(filmeEntity);
    }

   public List<Filme>list(){
    return  filmeRepository.findAll();
   }

   public List<Filme> delete(Long id){ 
     filmeRepository.deleteById(id);
     return list();
   }
    
}
