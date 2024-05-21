package br.com.fiap.anallyzer.apianallyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.apianallyzer.entities.cliente.Escolaridade;

public interface EscolaridadeRepository  extends JpaRepository<Escolaridade, Long>{
	Escolaridade findFirstById(Long id);
}
