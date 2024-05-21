package br.com.fiap.anallyzer.apianallyzer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.apianallyzer.entities.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Cliente findFirstByEmail(String email);
    Cliente findFirstById(Long id);
}
