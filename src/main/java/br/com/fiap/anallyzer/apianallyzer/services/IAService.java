package br.com.fiap.anallyzer.apianallyzer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.anallyzer.apianallyzer.dtos.IAResponseDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.CriarIaDto;
import br.com.fiap.anallyzer.apianallyzer.entities.ia.IA;
import br.com.fiap.anallyzer.apianallyzer.entities.ia.ResultadoIa;
import br.com.fiap.anallyzer.apianallyzer.exceptions.RegraDeNegocioException;
import br.com.fiap.anallyzer.apianallyzer.repositories.IARepository;
import br.com.fiap.anallyzer.apianallyzer.repositories.ResultadoIaRepository;
import jakarta.transaction.Transactional;

@Service
public class IAService {
	
	@Autowired
	private IARepository iaRepository;
	
	@Autowired
	private ResultadoIaRepository resultadoIARepository;
	
	@Transactional
	public IAResponseDto criar(CriarIaDto iaDto) {
		ResultadoIa resultado = resultadoIARepository.findFirstById(iaDto.idResultado());
		if (resultado == null) {
		    throw new RegraDeNegocioException("Não existe um resultado com o ID informado.");
		}
		
		IA novaIA = new IA();
		novaIA.setDescricao(iaDto.descricao());
		novaIA.setResultado(resultado);
		// Configure as outras associações como empresa e campanha, se necessário

		iaRepository.save(novaIA);
		
        return new IAResponseDto(novaIA.getId(), novaIA.getDescricao());
	}
	
	@Transactional
	public IAResponseDto buscarPorId(Long id) {
	    IA ia = iaRepository.findFirstById(id);
	    
	    if(ia == null) throw new RegraDeNegocioException("IA não encontrada");

	    return new IAResponseDto(ia.getId(), ia.getDescricao());
	}

}
