package br.com.fiap.anallyzer.apianallyzer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.anallyzer.apianallyzer.dtos.ClienteResponseDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.CriarClienteDto;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Campanha;
import br.com.fiap.anallyzer.apianallyzer.entities.cliente.Cliente;
import br.com.fiap.anallyzer.apianallyzer.entities.cliente.Escolaridade;
import br.com.fiap.anallyzer.apianallyzer.entities.cliente.EstadoCivil;
import br.com.fiap.anallyzer.apianallyzer.entities.cliente.Genero;
import br.com.fiap.anallyzer.apianallyzer.exceptions.RegraDeNegocioException;
import br.com.fiap.anallyzer.apianallyzer.repositories.CampanhaRepository;
import br.com.fiap.anallyzer.apianallyzer.repositories.ClienteRepository;
import br.com.fiap.anallyzer.apianallyzer.repositories.EscolaridadeRepository;
import br.com.fiap.anallyzer.apianallyzer.repositories.EstadoCivilRepository;
import br.com.fiap.anallyzer.apianallyzer.repositories.GeneroRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CampanhaRepository campanhaRepository;
	
	@Autowired
	private EscolaridadeRepository escolaridadeRepository;
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private EstadoCivilRepository estadoCivilRepository;
	
	@Transactional
	public ClienteResponseDto criar(CriarClienteDto cliente) {
		Cliente clienteExiste = clienteRepository.findFirstByEmail(cliente.email());
		Campanha campanhaExiste = campanhaRepository.findFirstById(cliente.idCampanha());
		Escolaridade possivelEscolaridade = escolaridadeRepository.findFirstById(cliente.idEscolaridade());
		Genero possivelGenero = generoRepository.findFirstById(cliente.idGenero());
		EstadoCivil possivelEstadoCivil= estadoCivilRepository.findFirstById(cliente.idEstadoCivil());

		if (clienteExiste != null) {
		    throw new RegraDeNegocioException("Já existe um cliente com o email informado.");
		}

		if (campanhaExiste == null) {
		    throw new RegraDeNegocioException("Não existe uma campanha com o ID informado.");
		}

		if (possivelEscolaridade == null) {
		    throw new RegraDeNegocioException("Não existe uma escolaridade com o ID informado.");
		}

		if (possivelGenero == null) {
		    throw new RegraDeNegocioException("Não existe um gênero com o ID informado.");
		}

		if (possivelEstadoCivil == null) {
		    throw new RegraDeNegocioException("Não existe um estado civil com o ID informado.");
		}
		
		Cliente novoCliente = new Cliente(cliente, possivelGenero, possivelEstadoCivil, possivelEscolaridade, campanhaExiste);
		
		clienteRepository.save(novoCliente);
		
        return new ClienteResponseDto(novoCliente.getId(), cliente.nome(), cliente.email(), cliente.dtNascimento(), novoCliente.getCampanha());
	}
	
	@Transactional
	public ClienteResponseDto buscarPorId(Long id) {
	    Cliente cliente = clienteRepository.findFirstById(id);
	    
	    if(cliente == null) throw new RegraDeNegocioException("Cliente não encontrado");

	    return new ClienteResponseDto(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getDtNascimento(), cliente.getCampanha());
	}

}
