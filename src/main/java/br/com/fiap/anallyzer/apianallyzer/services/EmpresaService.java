package br.com.fiap.anallyzer.apianallyzer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.anallyzer.apianallyzer.dtos.CriarEmpresaDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.EmpresaResponseDto;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Empresa;
import br.com.fiap.anallyzer.apianallyzer.entities.campanha.localizacao.Regiao;
import br.com.fiap.anallyzer.apianallyzer.exceptions.RegraDeNegocioException;
import br.com.fiap.anallyzer.apianallyzer.repositories.EmpresaRepository;
import br.com.fiap.anallyzer.apianallyzer.repositories.RegiaoRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Transactional
	public EmpresaResponseDto criar(CriarEmpresaDto empresa) {
		Regiao regiaoExiste = regiaoRepository.findFirstById(empresa.idRegiao());
		
		Empresa empresaExiste = empresaRepository.findFirstByCnpj(empresa.cnpj());
		
		if(regiaoExiste == null) {
			throw new RegraDeNegocioException("A região escolhida não está disponível no momento.");
		}
		
		if(empresaExiste != null) {
			throw new RegraDeNegocioException("Já existe uma empresa cadastrada com o cnpj informado.");
		}
		
		Empresa novaEmpresa = new Empresa(
	            empresa.nome(), 
	            empresa.cnpj(), 
	            empresa.contato(), 
	            regiaoExiste
	    );
		
		empresaRepository.save(novaEmpresa);
		
		return new EmpresaResponseDto(novaEmpresa.getId(), empresa, regiaoExiste);
	}
	
	@Transactional
	public EmpresaResponseDto buscarEmpresaPorId(Long id) {
		Empresa empresa = empresaRepository.findFirstById(id);
		
		if(empresa == null) {
			throw new RegraDeNegocioException("Empresa não encontrada");
		}
		
		return new EmpresaResponseDto(empresa.getId(), converterParaDto(empresa), empresa.getRegiao());
	}
	
	private CriarEmpresaDto converterParaDto(Empresa empresa) {
		return new CriarEmpresaDto(empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getContato());
	}
}
