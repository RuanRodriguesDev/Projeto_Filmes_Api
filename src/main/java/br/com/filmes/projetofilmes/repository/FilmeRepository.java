package br.com.filmes.projetofilmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filmes.projetofilmes.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    
}
