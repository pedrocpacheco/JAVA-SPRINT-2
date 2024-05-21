package br.com.fiap.anallyzer.apianallyzer.dtos;

import java.time.LocalDate;

import br.com.fiap.anallyzer.apianallyzer.entities.campanha.Campanha;

public record ClienteResponseDto(Long id, String nome, String email, LocalDate dtNascimento, Campanha campanha) {

}
