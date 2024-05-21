package br.com.fiap.anallyzer.apianallyzer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.anallyzer.apianallyzer.dtos.CampanhaResponseDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.CriarCampanhaDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.UpdateCampanhaReponseDto;
import br.com.fiap.anallyzer.apianallyzer.services.CampanhaService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("campanha") 
public class CampanhaController {
	@Autowired
	private CampanhaService campanhaService;
	
	@PostMapping
	public CampanhaResponseDto criar(@RequestBody @Valid CriarCampanhaDto campanha) {
		return this.campanhaService.criar(campanha);	}
	
	@GetMapping("{id}")
	public CampanhaResponseDto buscarPorId(@PathVariable("id") Long id) {
		return this.campanhaService.buscarPorId(id);
	}
	
	@PatchMapping("{id}")
	public CampanhaResponseDto atualizar(@PathVariable("id") Long id, @RequestBody @Valid UpdateCampanhaReponseDto campanhaDto) {
	    return this.campanhaService.atualizar(id, campanhaDto);
	}

	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable("id") Long id) {
	    this.campanhaService.deletar(id);
	}

}
