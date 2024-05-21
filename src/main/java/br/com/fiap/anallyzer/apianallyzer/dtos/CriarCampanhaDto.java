package br.com.fiap.anallyzer.apianallyzer.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarCampanhaDto(@NotNull Long idEmpresa, @NotNull Long idRegiao, @NotBlank() String titulo, @NotBlank() String descricao) {
	
}
