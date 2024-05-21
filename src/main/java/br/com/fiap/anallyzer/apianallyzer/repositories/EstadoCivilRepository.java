package br.com.fiap.anallyzer.apianallyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.apianallyzer.entities.cliente.EstadoCivil;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {
	EstadoCivil findFirstById(Long id);
}
