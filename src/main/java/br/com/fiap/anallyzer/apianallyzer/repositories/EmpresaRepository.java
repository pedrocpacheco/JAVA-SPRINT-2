package br.com.fiap.anallyzer.apianallyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	Empresa findFirstByCnpj(String cnpj);
	Empresa findFirstById(Long id);
}
