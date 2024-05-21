package br.com.fiap.anallyzer.apianallyzer.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarIaDto(
    @NotNull(message = "ID Resultado não pode ser nulo") 
    Long idResultado,
    @NotNull(message = "ID Empresa não pode ser nulo") 
    Long idEmpresa,
    @NotNull(message = "ID Campanha não pode ser nulo") 
    Long idCampanha,
    @NotBlank(message = "Descrição não pode ser nula") 
    String descricao
) {
  
}
