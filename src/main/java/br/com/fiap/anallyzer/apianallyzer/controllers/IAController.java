package br.com.fiap.anallyzer.apianallyzer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.anallyzer.apianallyzer.dtos.CriarIaDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.IAResponseDto;
import br.com.fiap.anallyzer.apianallyzer.services.IAService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ia")
public class IAController {
  @Autowired
	private IAService service;
	
	@PostMapping
	public IAResponseDto criar(@RequestBody @Valid CriarIaDto ia) {
		return service.criar(ia);
	}
	
	@GetMapping("{id}")
	public IAResponseDto buscarPorId(@PathVariable("id") Long id) {
		return service.buscarPorId(id);
	}
}
