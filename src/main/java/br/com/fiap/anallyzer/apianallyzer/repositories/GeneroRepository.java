package br.com.fiap.anallyzer.apianallyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.apianallyzer.entities.cliente.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long>{
	Genero findFirstById(Long id);
}
