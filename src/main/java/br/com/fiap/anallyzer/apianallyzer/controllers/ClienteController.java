package br.com.fiap.anallyzer.apianallyzer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.anallyzer.apianallyzer.dtos.ClienteResponseDto;
import br.com.fiap.anallyzer.apianallyzer.dtos.CriarClienteDto;
import br.com.fiap.anallyzer.apianallyzer.services.ClienteService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("clientes") 
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ClienteResponseDto criar(@RequestBody @Valid CriarClienteDto cliente) {
		return this.clienteService.criar(cliente);
	}
	
	@GetMapping("{id}")
	public ClienteResponseDto buscarPorId(@PathVariable Long id){
		return clienteService.buscarPorId(id);
	}
}