package br.com.fiap.anallyzer.apianallyzer.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateCampanhaReponseDto(
  @NotBlank(message = "Título não pode ser nulo")
  String titulo,
  
  @NotBlank(message = "Descrição não pode ser nula")
  String descricao
) {
}
