package br.com.fiap.anallyzer.apianallyzer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.anallyzer.apianallyzer.dtos.CriarEmpresaDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.EmpresaResponseDto;
import br.com.fiap.anallyzer.apianallyzer.services.EmpresaService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("empresas") 
public class EmpresaController {
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping
	public EmpresaResponseDto criar(@RequestBody @Valid CriarEmpresaDto empresa) {
		return this.empresaService.criar(empresa);
	}
	
	@GetMapping("{id}")
	public EmpresaResponseDto buscarPorId(@PathVariable("id") Long id) {
		return this.empresaService.buscarEmpresaPorId(id);
	}
}
