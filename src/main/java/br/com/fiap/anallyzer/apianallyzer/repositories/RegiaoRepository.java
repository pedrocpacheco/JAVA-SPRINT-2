package br.com.fiap.anallyzer.apianallyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao.Regiao;

public interface RegiaoRepository extends JpaRepository<Regiao, Long>{
    Regiao findFirstById(Long id);
}
