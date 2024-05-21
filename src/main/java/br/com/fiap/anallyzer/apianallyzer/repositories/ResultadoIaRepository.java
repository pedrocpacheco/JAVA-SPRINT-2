package br.com.fiap.anallyzer.apianallyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.apianallyzer.entities.ia.ResultadoIa;

public interface ResultadoIaRepository extends JpaRepository<ResultadoIa, Long>{
  ResultadoIa findFirstById(Long id);

}
