package br.com.fiap.anallyzer.apianallyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.apianallyzer.entities.ia.IA;

public interface IARepository extends JpaRepository<IA, Long>{
  IA findFirstById(Long id);

}
