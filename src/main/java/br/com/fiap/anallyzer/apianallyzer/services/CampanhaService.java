package br.com.fiap.anallyzer.apianallyzer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.anallyzer.apianallyzer.dtos.CampanhaResponseDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.CriarCampanhaDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.UpdateCampanhaReponseDto;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Campanha;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Empresa;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao.Regiao;
import br.com.fiap.anallyzer.apianallyzer.exceptions.RegraDeNegocioException;
import br.com.fiap.anallyzer.apianallyzer.repositories.CampanhaRepository;
import br.com.fiap.anallyzer.apianallyzer.repositories.EmpresaRepository;
import br.com.fiap.anallyzer.apianallyzer.repositories.RegiaoRepository;
import jakarta.transaction.Transactional;

@Service
public class CampanhaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private CampanhaRepository campanhaRepository;
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Transactional
	public CampanhaResponseDto criar(CriarCampanhaDto campanhaDto) {
		Regiao regiaoExiste = regiaoRepository.findFirstById(campanhaDto.idRegiao());
		
		Empresa possivelEmpresa = empresaRepository.findFirstById(campanhaDto.idEmpresa());
		
		if(regiaoExiste == null) {
			throw new RegraDeNegocioException("A região escolhida não está disponível no momento.");
		}
		
		if(possivelEmpresa == null) {
			throw new RegraDeNegocioException("A empresa da campanha não existe");
		}
		
		Campanha novaCampanha = new Campanha(campanhaDto.titulo(), campanhaDto.descricao(), possivelEmpresa, regiaoExiste);
		
		campanhaRepository.save(novaCampanha);
		
		return new CampanhaResponseDto(novaCampanha.getId(), converterParaDto(novaCampanha), possivelEmpresa, regiaoExiste);
	}
	
	@Transactional
	public void deletar(Long id) {
	    campanhaRepository.deleteById(id);
	}
	
	@Transactional
	public CampanhaResponseDto atualizar(Long id, UpdateCampanhaReponseDto campanhaDto) {
		System.out.println("salvo");
		Campanha campanha = campanhaRepository.findFirstById(id);

	    if(campanha == null) throw new RegraDeNegocioException("Campanha não encontrada");

	    if (campanhaDto.titulo() != null) {
	        campanha.setTitulo(campanhaDto.titulo());
	    }
	    if (campanhaDto.descricao() != null) {
	        campanha.setDescricao(campanhaDto.descricao());
	    }

	    campanhaRepository.save(campanha);

	    return new CampanhaResponseDto(campanha.getId(), converterParaDto(campanha), campanha.getEmpresa(), campanha.getRegiao());
	}

	
	private CriarCampanhaDto converterParaDto(Campanha campanha) {
		return new CriarCampanhaDto(campanha.getEmpresa().getId(), campanha.getRegiao().getId(), campanha.getTitulo(), campanha.getDescricao());
	}
	
	public CampanhaResponseDto buscarPorId(Long id) {
	    Campanha campanha = campanhaRepository.findFirstById(id);
	    
	    if(campanha == null) throw new RegraDeNegocioException("Campanha não encontrada");
	    
	    return new CampanhaResponseDto(campanha.getId(), converterParaDto(campanha), campanha.getEmpresa(), campanha.getRegiao());
	}

}
