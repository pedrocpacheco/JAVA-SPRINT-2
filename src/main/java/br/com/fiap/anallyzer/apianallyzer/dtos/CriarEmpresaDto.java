package br.com.fiap.anallyzer.apianallyzer.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarEmpresaDto(
  @NotNull(message = "Região não pode ser nula")
  Long idRegiao,
  
  @NotBlank(message = "Nome não pode ser nulo")
  String nome,
  
  @NotBlank(message = "CNPJ não pode ser nulo")
  String cnpj,
  
  @NotBlank(message = "Contato não pode ser nulo")
  String contato
) {
}
