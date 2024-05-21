package br.com.fiap.anallyzer.apianallyzer.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarClienteDto(
  @NotBlank(message = "Nome não pode ser nulo")
  String nome,
  @NotBlank(message = "Email não pode ser nulo")
  String email,
  @NotNull(message = "Data Nascimento não pode ser nula")
  LocalDate dtNascimento,
  @NotNull(message = "Genero não pode ser nulo")
  Long idGenero,
  @NotNull(message = "Estado Civil não pode ser nulo")
  Long idEstadoCivil,
  @NotNull(message = "Escolaridade não pode ser nula")
  Long idEscolaridade,
  @NotNull(message = "Campanha não pode ser nula")
  Long idCampanha
) {
}